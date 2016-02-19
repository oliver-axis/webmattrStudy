package server.api;



import server.Bus;
import webmattr.JSON;
import webmattr.Try;
import webmattr.action.ResponseCallback;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Date;


public abstract class AbstractAction<IN, OUT> {
//    private static final MonthDay JSON = ;
    private Bus bus;
    private Provider<IN> inProvider;
    private Provider<OUT> outProvider;
    private long started;
    private int timeoutMillis = 10000;
    private ActionCall<IN, OUT> call;

    public AbstractAction() {
    }

    public int timeoutMillis() {
        return timeoutMillis;
    }

    public Provider<IN> getInProvider() {
        return inProvider;
    }

    @Inject
    void setInProvider(Provider<IN> inProvider) {
        this.inProvider = inProvider;
    }

    public Provider<OUT> getOutProvider() {
        return outProvider;
    }

    @Inject
    void setOutProvider(Provider<OUT> outProvider) {
        this.outProvider = outProvider;
    }

    @Inject
    void setBus(Bus bus) {
        this.bus = bus;
    }

    protected ActionCall<IN, OUT> build() {
        return call = new ActionCall<IN, OUT>(in -> {
            beforeDispatch(in);
        }, inProvider);
    }

    /**
     * @param request
     */
    protected void beforeDispatch(IN request) {
        started = new Date().getTime();
        this.timeoutMillis = call.timeoutMillis();
        bus.publish(request);
        dispatch(request);
    }

    /**
     * @param request
     */
    protected void dispatch(IN request) {
        Try.later(() -> handle(request));
    }

    /**
     * @param request
     */
    protected abstract void handle(IN request);

    /**
     * @param e
     */
    protected void error(Throwable e) {
        call.onError(e);
    }

    /**
     * @param response
     */
    protected void respond(OUT response) {
        call.onResponse(response);
    }

    /**
     * @param callback
     */
    protected void respond(ResponseCallback<OUT> callback) {
        final OUT out = outProvider.get();
        try {
            if (callback != null) {
                callback.call(out);
            }
            call.onResponse(out);
        } catch (Throwable e) {
            call.failed(e);
        }
    }

    /**
     * @param json
     * @return
     */
    protected IN parseIn(String json) {
        final IN in = inProvider.get();
        if (in == null) {
            return null;
        }
        return JSON.parse(json, in);
    }

    /**
     * @param json
     * @return
     */
    protected OUT parseOut(String json) {
        final OUT out = outProvider.get();
        if (out == null) {
            return null;
        }
        return JSON.parse(json, out);
    }
}
