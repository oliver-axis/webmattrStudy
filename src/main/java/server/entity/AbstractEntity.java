package server.entity;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Date;

@JsType(
    isNative = true
)
public class AbstractEntity {
  protected AbstractEntity() {
  }

  @JsProperty(
      name = "id"
  )
  protected native String getId();

  @JsProperty(
      name = "id"
  )
  protected native void setId(String value);

  @JsOverlay
  public final String id() {
    return getId();
  }

  @JsOverlay
  public final AbstractEntity id(final String value) {
    setId(value);
    return this;
  }

  @JsProperty(
      name = "version"
  )
  protected native double getVersion();

  @JsProperty(
      name = "version"
  )
  protected native void setVersion(double value);

  @JsOverlay
  public final double version() {
    return getVersion();
  }

  @JsOverlay
  public final AbstractEntity version(final double value) {
    setVersion(value);
    return this;
  }

  @JsProperty(
      name = "changed"
  )
  protected native Date getChanged();

  @JsProperty(
      name = "changed"
  )
  protected native void setChanged(Date value);

  @JsOverlay
  public final Date changed() {
    return getChanged();
  }

  @JsOverlay
  public final AbstractEntity changed(final Date value) {
    setChanged(value);
    return this;
  }

  public static class Factory implements Provider<AbstractEntity> {
    @Inject
    public Factory() {
    }

    @Override
    public native AbstractEntity get() /*-{
      return {};
    }-*/;

    public static native AbstractEntity create() /*-{
      return {};
    }-*/;
  }
}
