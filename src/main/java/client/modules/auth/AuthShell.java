package client.modules.auth;

import webmattr.react.ReactComponent;
import webmattr.react.ReactElement;
import webmattr.router.RootRoute;
import webmattr.router.SimpleRouteComponent;
import webmattr.router.SimpleRouteProps;
import webmattr.router.SimpleRouteProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

import static webmattr.dom.DOM.div;
import static webmattr.dom.DOM.h1;

/**
 *
 */
@Singleton
public class AuthShell extends SimpleRouteComponent<AuthShell.Route, AuthShell.Props, AuthShell.State> {
    @Inject
    public AuthShell() {
    }

//    @Override  // is this needed anymore?
    protected void componentWillMount(final ReactComponent<Props, State> $this, Props props, State state) {
        super.componentWillMount($this, props, state);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Render
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected ReactElement render(ReactComponent $this, Props props, State state) {
        return
                div(
                        h1($ -> $.className(""),
                                "something cool"
                        ),
                        (ReactElement) props.children
                ) ;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Props
    ///////////////////////////////////////////////////////////////////////////////////////////////////


    public static class Props extends SimpleRouteProps {
        @Inject
        public Props() {
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // State
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public static class State {
        @Inject
        public State() {
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Route
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public static class Route extends SimpleRouteProxy {
        @Inject
        public Route(RootRoute parent) {
            super("a", parent);
        }
    }
}
