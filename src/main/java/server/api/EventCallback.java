package server.api;

import com.google.gwt.event.shared.EventHandler;

/**
 *
 */
public interface EventCallback<T> extends EventHandler {
    void call(T event);
}
