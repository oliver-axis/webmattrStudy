package client.modules;

import webmattr.react.ReactComponent;
import webmattr.react.ReactElement;
import webmattr.router.RootRoute;
import webmattr.router.SimpleRouteComponent;
import webmattr.router.SimpleRouteProps;

import javax.inject.Inject;
import javax.inject.Singleton;

import static webmattr.dom.DOM.div;

/**
 *
 */
@Singleton
public class RootShell extends SimpleRouteComponent<RootRoute, RootShell.Props, RootShell.State> {
//    private final AlertManager alertManager;
//    private final ConfirmManager confirmManager;
//    private final ProcedureManager procedureManager; // xyzzy


    @Inject
    public RootShell() {
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Render
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected ReactElement render(ReactComponent $this, Props props, State state) {
        return
                div($ -> $.className("full-height"),
                    props.children
                );
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
}
