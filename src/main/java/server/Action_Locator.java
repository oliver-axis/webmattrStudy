package server;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Action_Locator {
  @Inject
  server.v1.Action_Locator v1;

  @Inject
  Action_Locator() {
  }

  public final server.v1.Action_Locator v1() {
    return v1;
  }
}
