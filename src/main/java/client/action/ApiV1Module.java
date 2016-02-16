package client.action;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
//import move.v1.TypesModule;
import server.Action_Locator;
import client.App;
import webmattr.Bus;
import webmattr.ws.WsDispatcher;

import javax.inject.Singleton;

/**
 *
 */
@Singleton
@Component(modules = {App.Core.class, ApiV1Module.M.class})  // , TypesModule.class
public interface ApiV1Module {
    Action_Locator root();

    WsDispatcher dispatcher();

    @Module
    public static class M {
        private String url;

        public M(String url) {
            this.url = url;
        }

        @Provides
        WsDispatcher dispatcher(Bus bus) {
            WsDispatcher dispatcher = new WsDispatcher(bus, this.url);
            dispatcher.start();
            return dispatcher;
        }
    }
}
