package client.modules.gatekeepers;

import elemental.client.Browser;
import client.security.Session;
import webmattr.router.ReplaceStateFunction;
import webmattr.router.RouteGatekeeper;
import webmattr.router.RouteProps;
import webmattr.router.RouteProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class RouteListener implements RouteGatekeeper {
//    @Inject
//    Session session;

    @Inject
    public RouteListener() {
    }

    @Override
    public void onEnter(RouteProxy routeProxy, RouteProps routeProps, ReplaceStateFunction replaceStateFunction) {
        /*if (!session.loggedIn()
            && !routeProxy.is(App.getRoutes().getAuth().getLogin())
            && !routeProps.getLocation().getPathname().contains(App.getRoutes().getAuth().getLogin().buildPath())) {
            session.nextPathname(routeProps.getLocation().getPathname());
            session.attemptedRoute(routeProxy);
            replaceStateFunction.call(new ReplaceState(), App.getRoutes().getAuth().getLogin().buildPath());
        }*/
    }

    @Override
    public Object onLeave(RouteProxy routeProxy) {
        Browser.getWindow().getConsole().log("RouteGatekeeper:onLeave: " + routeProxy.getClass().getName());
        return null;
    }
}
