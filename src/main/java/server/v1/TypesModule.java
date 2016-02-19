package server.v1;

import dagger.Module;
import dagger.Provides;
import server.entity.AbstractEntity;
import server.entity.security.UserEntity;
import server.security.User;
import server.v1.action.auth.Login;

import javax.inject.Provider;

@Module
public class TypesModule {

  @Provides
  UserEntity _234() {
    return UserEntity.Factory.create();
  }

  @Provides
  Provider<UserEntity> _234_() {
    return new UserEntity.Factory();
  }



  @Provides
  AbstractEntity _243() {
    return AbstractEntity.Factory.create();
  }

  @Provides
  Provider<AbstractEntity> _243_() {
    return new AbstractEntity.Factory();
  }


  @Provides
  User _246() {
    return User.Factory.create();
  }

  @Provides
  Provider<User> _246_() {
    return new User.Factory();
  }

  @Provides
  Login.Response _5() {
    return Login.Response.Factory.create();
  }

  @Provides
  Provider<Login.Response> _5_() {
    return new Login.Response.Factory();
  }

  @Provides
  Login.Request _6() {
    return Login.Request.Factory.create();
  }

  @Provides
  Provider<Login.Request> _6_() {
    return new Login.Request.Factory();
  }

}
