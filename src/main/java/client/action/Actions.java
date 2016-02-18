package client.action;

import dagger.Lazy;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class Actions {
    private Lazy<server.Action_Locator> v1;

    @Inject
    public Actions(Lazy<server.Action_Locator> v1) {
        // Build API.
        this.v1 = v1;
    }

    public server.Action_Locator v1() {
        return v1.get();
    }
}
