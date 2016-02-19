package server.v1.action.auth;


import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import server.security.User;
import webmattr.ws.WsAction;

import javax.inject.Inject;
import javax.inject.Provider;

public class Login extends WsAction<Login.Request, Login.Response> {
  @Inject
  public Login() {
  }

  @Override
  protected String path() {
    return "/auth/login";
  }

  public enum Code {
    SUCCESS,

    FAILED,

    SESSION_NOT_LOCATED,

    EMAIL_OR_PASSWORD_NOT_SET,

    USER_NOT_FOUND,

    PASSWORD_FAILED,

    USER_UNAVAILABLE,

    SESSION_REFUSED,

    USER_LINK_NOT_FOUND
  }

  @JsType(
      isNative = true
  )
  public static class Response {
    protected Response() {
    }

    @JsProperty(
        name = "code"
    )
    protected native String getCode();

    @JsProperty(
        name = "code"
    )
    protected native void setCode(String value);

    @JsOverlay
    public final Code code() {
      try {
        return Code.valueOf(getCode());
      }
      catch (Throwable e) {
        setCode(null);
        return null;
      }
    }

    @JsOverlay
    public final Response code(final Code value) {
      setCode(value != null ? value.toString() : null);
      return this;
    }

    @JsProperty(
        name = "sessionId"
    )
    protected native String getSessionId();

    @JsProperty(
        name = "sessionId"
    )
    protected native void setSessionId(String value);

    @JsOverlay
    public final String sessionId() {
      return getSessionId();
    }

    @JsOverlay
    public final Response sessionId(final String value) {
      setSessionId(value);
      return this;
    }

    @JsProperty(
        name = "user"
    )
    protected native User getUser();

    @JsProperty(
        name = "user"
    )
    protected native void setUser(User value);

    @JsOverlay
    public final User user() {
      return getUser();
    }

    @JsOverlay
    public final Response user(final User value) {
      setUser(value);
      return this;
    }

    @JsProperty(
        name = "logLevel"
    )
    protected native String getLogLevel();

    @JsProperty(
        name = "logLevel"
    )
    protected native void setLogLevel(String value);

    @JsOverlay
    public final String logLevel() {
      return getLogLevel();
    }

    @JsOverlay
    public final Response logLevel(final String value) {
      setLogLevel(value);
      return this;
    }

    public static class Factory implements Provider<Response> {
      @Inject
      public Factory() {
      }

      @Override
      public native Response get() /*-{
        return {};
      }-*/;

      public static native Response create() /*-{
        return {};
      }-*/;
    }
  }

  @JsType(
      isNative = true
  )
  public static class Request {
    protected Request() {
    }

    @JsProperty(
        name = "email"
    )
    protected native String getEmail();

    @JsProperty(
        name = "email"
    )
    protected native void setEmail(String value);

    @JsOverlay
    public final String email() {
      return getEmail();
    }

    @JsOverlay
    public final Request email(final String value) {
      setEmail(value);
      return this;
    }

    @JsProperty(
        name = "password"
    )
    protected native String getPassword();

    @JsProperty(
        name = "password"
    )
    protected native void setPassword(String value);

    @JsOverlay
    public final String password() {
      return getPassword();
    }

    @JsOverlay
    public final Request password(final String value) {
      setPassword(value);
      return this;
    }

    @JsProperty(
        name = "deviceType"
    )
    protected native String getDeviceType();

    @JsProperty(
        name = "deviceType"
    )
    protected native void setDeviceType(String value);

//    @JsOverlay
//    public final DeviceType deviceType() {
//      try {
//        return DeviceType.valueOf(getDeviceType());
//      }
//      catch (Throwable e) {
//        setDeviceType(null);
//        return null;
//      }
//    }
//
//    @JsOverlay
//    public final Request deviceType(final DeviceType value) {
//      setDeviceType(value != null ? value.toString() : null);
//      return this;
//    }

    @JsProperty(
        name = "deviceId"
    )
    protected native String getDeviceId();

    @JsProperty(
        name = "deviceId"
    )
    protected native void setDeviceId(String value);

    @JsOverlay
    public final String deviceId() {
      return getDeviceId();
    }

    @JsOverlay
    public final Request deviceId(final String value) {
      setDeviceId(value);
      return this;
    }

    @JsProperty(
        name = "userAgent"
    )
    protected native String getUserAgent();

    @JsProperty(
        name = "userAgent"
    )
    protected native void setUserAgent(String value);

    @JsOverlay
    public final String userAgent() {
      return getUserAgent();
    }

    @JsOverlay
    public final Request userAgent(final String value) {
      setUserAgent(value);
      return this;
    }

    @JsProperty(
        name = "sessionId"
    )
    protected native String getSessionId();

    @JsProperty(
        name = "sessionId"
    )
    protected native void setSessionId(String value);

    @JsOverlay
    public final String sessionId() {
      return getSessionId();
    }

    @JsOverlay
    public final Request sessionId(final String value) {
      setSessionId(value);
      return this;
    }

    public static class Factory implements Provider<Request> {
      @Inject
      public Factory() {
      }

      @Override
      public native Request get() /*-{
        return {};
      }-*/;

      public static native Request create() /*-{
        return {};
      }-*/;
    }
  }
}
