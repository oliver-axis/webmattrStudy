package server.v1.action;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Action_Locator {

  @Inject
  server.v1.action.auth.Action_Locator auth;

  @Inject
  Action_Locator() {
  }

  public final server.v1.action.auth.Action_Locator auth() {
    return auth;
  }
}
