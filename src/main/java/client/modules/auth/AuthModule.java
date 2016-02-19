package client.modules.auth;

import client.modules.auth.login.LoginPage;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import dagger.Component;
import client.App;
import webmattr.Func;
import webmattr.router.ModuleLoader;
import webmattr.router.RoutesBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
@Component(modules = App.Core.class)
public interface AuthModule {
    AuthModule instance = DaggerAuthModule.create();

    Routes routes();

    /**
     *
     */
    @Singleton
    class Routes extends RoutesBuilder {
        @Inject
        AuthShell shell;
        @Inject
        LoginPage login;
//        @Inject
//        ForgotPasswordPage forgotPassword;
//        @Inject
//        RegistrationPage registration;

        @Inject
        public Routes() {
        }

        @Override
        protected void registerComponents() {
            add(shell);
            add(login);
        }
    }

    class Loader extends ModuleLoader {
        @Inject
        public Loader(AuthShell.Route root) {
            super(root.path());
        }

        @Override
        protected void loadRouteBuilder(Func.Run1<RoutesBuilder> callback) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable reason) {
                    // Ignore.
                }

                @Override
                public void onSuccess() {
                    callback.run(AuthModule.instance.routes());
                }
            });
        }
    }
}