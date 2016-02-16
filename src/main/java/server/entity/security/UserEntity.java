package server.entity.security;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import server.entity.AbstractEntity;
import server.security.user.UserPerspective;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Date;

@JsType(
    isNative = true
)
public class UserEntity extends AbstractEntity {
  protected UserEntity() {
  }

  @JsProperty(
      name = "userPerspective"
  )
  protected native String getUserPerspective();

  @JsProperty(
      name = "userPerspective"
  )
  protected native void setUserPerspective(String value);

  @JsOverlay
  public final UserPerspective userPerspective() {
    try {
      return UserPerspective.valueOf(getUserPerspective());
    }
    catch (Throwable e) {
      setUserPerspective(null);
      return null;
    }
  }

  @JsOverlay
  public final UserEntity userPerspective(final UserPerspective value) {
    setUserPerspective(value != null ? value.toString() : null);
    return this;
  }

  @JsProperty(
      name = "linkedId"
  )
  protected native String getLinkedId();

  @JsProperty(
      name = "linkedId"
  )
  protected native void setLinkedId(String value);

  @JsOverlay
  public final String linkedId() {
    return getLinkedId();
  }

  @JsOverlay
  public final UserEntity linkedId(final String value) {
    setLinkedId(value);
    return this;
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
  public final UserEntity email(final String value) {
    setEmail(value);
    return this;
  }

  @JsProperty(
      name = "signupDate"
  )
  protected native Date getSignupDate();

  @JsProperty(
      name = "signupDate"
  )
  protected native void setSignupDate(Date value);

  @JsOverlay
  public final Date signupDate() {
    return getSignupDate();
  }

  @JsOverlay
  public final UserEntity signupDate(final Date value) {
    setSignupDate(value);
    return this;
  }

  @JsProperty(
      name = "username"
  )
  protected native String getUsername();

  @JsProperty(
      name = "username"
  )
  protected native void setUsername(String value);

  @JsOverlay
  public final String username() {
    return getUsername();
  }

  @JsOverlay
  public final UserEntity username(final String value) {
    setUsername(value);
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
  public final UserEntity password(final String value) {
    setPassword(value);
    return this;
  }

  @JsProperty(
      name = "timeZone"
  )
  protected native String getTimeZone();

  @JsProperty(
      name = "timeZone"
  )
  protected native void setTimeZone(String value);

  @JsProperty(
      name = "availablePerspective"
  )
  protected native String getAvailablePerspective();

  @JsProperty(
      name = "availablePerspective"
  )
  protected native void setAvailablePerspective(String value);

  @JsOverlay
  public final AvailablePerspective availablePerspective() {
    try {
      return AvailablePerspective.valueOf(getAvailablePerspective());
    }
    catch (Throwable e) {
      setAvailablePerspective(null);
      return null;
    }
  }

  @JsOverlay
  public final UserEntity availablePerspective(final AvailablePerspective value) {
    setAvailablePerspective(value != null ? value.toString() : null);
    return this;
  }

  @JsProperty(
      name = "status"
  )
  protected native String getStatus();

  @JsProperty(
      name = "status"
  )
  protected native void setStatus(String value);

  @JsOverlay
  public final UserStatus status() {
    try {
      return UserStatus.valueOf(getStatus());
    }
    catch (Throwable e) {
      setStatus(null);
      return null;
    }
  }

  @JsOverlay
  public final UserEntity status(final UserStatus value) {
    setStatus(value != null ? value.toString() : null);
    return this;
  }

  public static class Factory implements Provider<UserEntity> {
    @Inject
    public Factory() {
    }

    @Override
    public native UserEntity get() /*-{
      return {};
    }-*/;

    public static native UserEntity create() /*-{
      return {};
    }-*/;
  }
}
