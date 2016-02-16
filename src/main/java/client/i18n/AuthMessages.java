package client.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

/**
 *
 */
public interface AuthMessages extends Messages {
    AuthMessages instance = GWT.create(AuthMessages.class);

    @DefaultMessage("Move Medical")
    String MoveMedical();

    @DefaultMessage("Move")
    String Move();

    @DefaultMessage("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
    String LoginBlurb();

    @DefaultMessage("Login")
    String Login();

    @DefaultMessage("Username")
    String username();

    @DefaultMessage("Password")
    String password();

    @DefaultMessage("Forgot password?")
    String forgotPassword();

    @DefaultMessage("Have an account? Please go to")
    String haveAnAccount();

    @DefaultMessage("Create an account")
    String createAnAccount();

    @DefaultMessage("Do not have an account?")
    String doYouHaveAnAccount();

    @DefaultMessage("Some cool things about Move Medical")
    String moveMedicalBlurb();

    @DefaultMessage("Remember Me")
    String rememberMe();

    @DefaultMessage("Enter your email address and your password will be reset and emailed to you.")
    String forgotPasswordBlurb();

    @DefaultMessage("© {0}. ALL RIGHTS RESERVED.")
    String CopyrightIconYearAllRightsReserved(int year);

    @DefaultMessage("Send new password")
    String sendNewPassword();

    @DefaultMessage("Email")
    String email();

    @DefaultMessage("Welcome to Move Medical")
    String welcomeToMoveMedical();

    @DefaultMessage("Sign In")
    String SignIn();

    @DefaultMessage("Lorem ipsum dolor sit amet, consectetur adipisicing elit.")
    String SignInBlurb();

    @DefaultMessage("No Account?")
    String NoAccountQuestionMark();

    @DefaultMessage("Sign Up")
    String SignUp();

    @DefaultMessage("© 2016 Axis Medical Technologies")
    String CopyrightAxisMedTech();

    @DefaultMessage("Email")
    String Email();

    @DefaultMessage("Password")
    String Password();

    @DefaultMessage("Remember Me")
    String RememberMe();

    @DefaultMessage("Forgot Your Password?")
    String ForgotYourPassword();

    @DefaultMessage("Input your registered email to reset your password")
    String ForgotPswdSubtext();

    @DefaultMessage("Error")
    String Error();

    @DefaultMessage("Login Failed")
    String LoginFailed();
}
