package server.security;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import server.entity.AbstractEntity;
import server.entity.security.UserEntity;

import javax.inject.Inject;
import javax.inject.Provider;

@JsType(
    isNative = true
)
public class User {
  protected User() {
  }

  @JsProperty(
      name = "entity"
  )
  protected native UserEntity getEntity();

  @JsProperty(
      name = "entity"
  )
  protected native void setEntity(UserEntity value);

  @JsOverlay
  public final UserEntity entity() {
    return getEntity();
  }

  @JsOverlay
  public final User entity(final UserEntity value) {
    setEntity(value);
    return this;
  }

  @JsProperty(
      name = "contactEntity"
  )
  protected native AbstractEntity getContactEntity();

  @JsProperty(
      name = "contactEntity"
  )
  protected native void setContactEntity(AbstractEntity value);

  @JsOverlay
  public final AbstractEntity contactEntity() {
    return getContactEntity();
  }

  @JsOverlay
  public final User contactEntity(final AbstractEntity value) {
    setContactEntity(value);
    return this;
  }

  public static class Factory implements Provider<User> {
    @Inject
    public Factory() {
    }

    @Override
    public native User get() /*-{
      return {};
    }-*/;

    public static native User create() /*-{
      return {};
    }-*/;
  }
}
