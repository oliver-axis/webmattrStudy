package client.modules;

import client.modules.auth.login.LoginPage;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class Routes {
    @Inject
    AuthRoutes auth;


    @Inject
    public Routes() {
    }

    public AuthRoutes getAuth() {
        return auth;
    }

    public static class AuthRoutes {
        @Inject
        LoginPage.Route login;
//        @Inject
//        ForgotPasswordPage.Route forgotPassword;
//        @Inject
//        RegistrationPage.Route registration;


        @Inject
        public AuthRoutes() {
        }

        public LoginPage.Route getLogin() {
            return login;
        }
    }


//    public static class AdminRoutes {
//        @Inject
//        ProcedureAdmin.Route procedures;
//        @Inject
//        UsersAdmin.Route users;
//        @Inject
//        UserDetail.Route userDetail;
//        @Inject
//        ProcedureDetail.Route procedureDetail;
//
//        @Inject
//        public AdminRoutes() {
//        }
//
//        public ProcedureAdmin.Route getProcedures() {
//            return procedures;
//        }
//
//        public UsersAdmin.Route getUsers() {
//            return users;
//        }
//
//        public UserDetail.Route getUserDetail() {
//            return userDetail;
//        }
//
//        public ProcedureDetail.Route getProcedureDetail() {
//            return procedureDetail;
//        }
//    }
}
