package client.security;

//import move.v1.security.user.User;
import webmattr.router.RouteProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class Session {
    private boolean loggedIn;
    private RouteProxy attemptedRoute;
    private String nextPathname;
//    private User user;
    private String sessionId;

    @Inject
    public Session() {
    }

    public Session sessionId(final String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

//    public Session user(final User user) {
//        this.user = user;
//        return this;
//    }

    public boolean loggedIn() {
        return this.loggedIn;
    }

    public Session loggedIn(final boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public RouteProxy attemptedRoute() {
        return this.attemptedRoute;
    }

    public Session attemptedRoute(final RouteProxy attemptedRoute) {
        this.attemptedRoute = attemptedRoute;
        return this;
    }

    public String nextPathname() {
        return this.nextPathname;
    }

    public Session nextPathname(final String nextPathname) {
        this.nextPathname = nextPathname;
        return this;
    }

    public void appStarted() {

    }
}
