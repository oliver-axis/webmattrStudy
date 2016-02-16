package server;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Action_Locator {

  @Inject
  Action_Locator auth;

  @Inject
  Action_Locator() {
  }


  public final Action_Locator auth() {
    return auth;
  }
}
