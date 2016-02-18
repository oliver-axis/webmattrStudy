package client;

import client.action.Actions;
import client.action.v1.ApiV1Module;
import client.security.Session;
import com.google.gwt.core.client.GWT;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import server.Action_Locator;
//import client.action.mockApi.DaggerMockApiModule;
//import client.action.mockApi.MockApi;
//import client.action.v1.DaggerApiV1Module;
import client.modules.RootModule;
import client.modules.Routes;
import client.modules.gatekeepers.RouteListener;
import client.util.SuperDevModeIndicator;
import server.v1.TypesModule;
import webmattr.Bus;
import webmattr.react.Props;
import webmattr.router.History;
import webmattr.router.ReactRouter;
import webmattr.router.RouteGatekeeper;
import webmattr.router.RouteProps;

import javax.inject.Singleton;

/**
 *
 */
@Singleton
@Component(modules = {App.M.class, TypesModule.class})
public interface App {
    App instance = DaggerApp.create();

    ////////////////////////////////////////////////////////////////////////////////////////
    // Convenience Methods
    ////////////////////////////////////////////////////////////////////////////////////////

    static boolean isSuperDevMode() {
        return ((SuperDevModeIndicator) GWT.create(SuperDevModeIndicator.class)).isSuperDevMode();
    }

    static History getHistory() {
        return instance.history();
    }

    static Bus getBus() {
        return instance.bus();
    }

//    static Actions getActions() {
//        return instance.actions();
//    }

    static Routes getRoutes() {
        return instance.routes();
    }

    static Session getSession() {
        return instance.session();
    }


    ////////////////////////////////////////////////////////////////////////////////////////
    // Top Level Dependencies
    ////////////////////////////////////////////////////////////////////////////////////////

    History history();

    Bus bus();

    Actions actions();

    RootModule bootstrap();

    Session session();

    Routes routes();

    RouteListener routeListener();

    ApiV1Module v1();


    ////////////////////////////////////////////////////////////////////////////////////////
    // Module
    ////////////////////////////////////////////////////////////////////////////////////////

    @Module
    class M {
        @Provides
        ApiV1Module v1Module() {
            // Configure Api module.
            return DaggerApiV1Module
                .builder()
                .m(new ApiV1Module.M("ws://localhost:8910/v1"))
                .build();
        }
//
//        ////////////////////////////////////////////////////////////////////////////////////////
//        // Configure API Module.
//        ////////////////////////////////////////////////////////////////////////////////////////
        @Provides
        @Singleton
        Action_Locator api(ApiV1Module v1Module) {
            return v1Module.root();
        }

        ////////////////////////////////////////////////////////////////////////////////////////
        // Configure Route Gatekeeper.
        ////////////////////////////////////////////////////////////////////////////////////////
            @Provides
            @Singleton
            RouteGatekeeper onEnter(RouteListener routeListener) {
                return routeListener;
            }

        ////////////////////////////////////////////////////////////////////////////////////////
        // Configure history.
        ////////////////////////////////////////////////////////////////////////////////////////
        @Provides
        @Singleton
        History history() {
            return ReactRouter.getHashHistory();
        }

        ////////////////////////////////////////////////////////////////////////////////////////
        // Defaults
        ////////////////////////////////////////////////////////////////////////////////////////
        @Provides
        Props props() {
            return new Props();
        }

        @Provides
        RouteProps routeProps() {
            return new RouteProps();
        }

        @Provides
        Object object() {
            return new Object();
        }
    }

    /**
     *
     */
    @Module
    class Core {
        @Provides
        App app() {
            return instance;
        }

        @Provides
        @Singleton
        Actions actions() {
            return app().actions();
        }

        @Provides
        @Singleton
        History history() {
            return app().history();
        }

        @Provides
        @Singleton
        Bus bus() {
            return app().bus();
        }

        @Provides
        Props props() {
            return new Props();
        }

        @Provides
        RouteProps routeProps() {
            return new RouteProps();
        }

        @Provides
        RouteGatekeeper routeGatekeeper() {
            return app().routeListener();
        }

        @Provides
        Object object() {
            return new Object();
        }
    }
}