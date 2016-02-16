package client.modules;

//import client.modules.app.AppModule;
import client.modules.auth.AuthModule;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class RootModule extends webmattr.router.RootModule {
    @Inject
    AuthModule.Loader auth;
//    @Inject
//    AppModule.Loader app;

    @Inject
    public RootModule(RootShell shell) {
        super(shell);
    }

    @Override
    protected void registerModules() {
        register(auth);
//        register(app);
    }
}
