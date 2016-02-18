package server.v1;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Action_Locator {
  @Inject
  server.v1.action.Action_Locator action;

  @Inject
  Action_Locator() {
  }

  public final server.v1.action.Action_Locator action() {
    return action;
  }
}
