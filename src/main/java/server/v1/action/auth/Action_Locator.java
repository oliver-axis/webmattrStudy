package server.v1.action.auth;

import webmattr.action.ActionProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Action_Locator {

  @Inject
  ActionProvider<Login, Login.Request, Login.Response, Login.Request.Factory, Login.Response.Factory> login;

  @Inject
  Action_Locator() {
  }


  public ActionProvider<Login, Login.Request, Login.Response, Login.Request.Factory, Login.Response.Factory> Login() {
    return login;
  }

}
