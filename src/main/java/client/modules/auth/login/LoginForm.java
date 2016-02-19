package client.modules.auth.login;

import client.App;
import elemental.html.InputElement;
import server.v1.action.auth.Login;
import webmattr.react.BaseProps;
import webmattr.react.Component;
import webmattr.react.ReactComponent;
import webmattr.react.ReactElement;
import webmattr.router.Location;
import webmattr.router.LocationDescriptor;
import webmattr.router.RouteProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

import static webmattr.dom.DOM.*;
import static webmattr.dom.DOM.button;


/**
 *
 */
@Singleton
public class LoginForm extends Component<LoginForm.Props, LoginForm.State> {

    @Inject
    public LoginForm() {
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Render
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected State getInitialState(ReactComponent<Props, State> $this) {
        return new State().email("med_device_company_hcr_1@axismedtech.com").password("passme");
    }

    @Override
    protected ReactElement render(ReactComponent<Props, State> $this, Props props, State state) {
        return
            form($ -> $.className("login-form")
                    .role("form")
                    .formNoValidate(true),
                div($ -> $.className("form-group"),
                    label($ -> $.className("sr-only"), "Email"),
                    input($ -> $.className("form-control")
                        .type("email")
                        .placeholder("Email")
                        .value(state.email)
                        .onChange(formEvent -> $this.setState(state.email(((InputElement) formEvent.getTarget()).getValue())))
                    )
                ),
                div($ -> $.className("form-group"),
                    label($ -> $.className("sr-only"), "Password"),
                    input($ -> $
                        .className("form-control")
                        .type("password")
                        .placeholder("Password")
                        .value(state.password)
                        .onChange(formEvent -> $this.setState(state.password(((InputElement) formEvent.getTarget()).getValue())))
                    )
                ),
                div($ -> $.className("form-group clearfix"),
                    div($ -> $.className("checkbox-custom checkbox-inline checkbox-primary pull-left"),
                        input($ -> $
                            .type("checkbox")
                            .id("remember")
                        ),
                        label($ -> $.htmlFor("remember"), "Remember Me")),
                    div($ -> $.className("pull-right")
//                            ,
//                        a($ -> $.onClick(event -> App.getRoutes().getAuth().getForgotPassword().go()), "Forgot Password")
                    )
                ),
                button($ -> $
                        .className("submit-btn btn btn-primary btn-block" + (state.canSubmit() ? "" : " disabled"))
                        .type("submit")
                        .onClick(mouseEvent -> {
                            mouseEvent.preventDefault();
                            if (!state.canSubmit()) {
                                return;
                            }
                            submit($this);
                        }),
                    "Login"
                )
            );
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void componentWillMount(ReactComponent<Props, State> $this, Props props, State state) {
        super.componentWillMount($this, props, state);
        intakeProps($this, props);
    }

    @Override
    protected void componentWillReceiveProps(ReactComponent<Props, State> $this, Props nextProps) {
        super.componentWillReceiveProps($this, nextProps);
        intakeProps($this, nextProps);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Actions
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    private void intakeProps(ReactComponent<Props, State> $this, Props props) {
//        $this.setState($this.state().email(props.email));
    }

    private void submit(ReactComponent<Props, State> $this) {
        App.getRoutes().getAuth().getLogin().go(); // todo fix this all

//        $this.setState($this.state().submitting(true));
////        ClearDiv.show();
//
//        dispatch($this, App.getActions().v1().auth().Login())
//            .buildRequest(request -> {
//                request.email($this.state().email);
//                request.password($this.state().password);
//            })
//            .always()  // wasDispatched -> ClearDiv.hide()
//            .onResponse(response -> {
//                if (!response.code().equals(Login.Code.SUCCESS)) {
////                    alert(msg.LoginFailed(), "Code: " + response.code().toString(), () -> {
////                        $this.setState($this.state().password("").submitting(false));
////                    });
//                    return;
//                }
//
//                App.getSession()
//                    .user(response.user())
//                    .sessionId(response.sessionId())
//                    .loggedIn(true);
//
//                bus().publish(new LoginEvent());
//
//                final RouteProxy attemptedRoute = App.getSession().attemptedRoute();
//                console.log(attemptedRoute);
//                final Location nextLocation = App.getSession().nextLocation();
//                console.log(nextLocation);
//
//                if (nextLocation != null && !App.getRoutes().getAuth().getLogin().buildLocation().pathname.contains(nextLocation.getPathname())) {
//                    App.getSession().attemptedRoute(null);
//                    App.getSession().nextLocation(null);
//                    App.getHistory().replace(new LocationDescriptor().pathname(nextLocation.getPathname()).search(nextLocation.getSearch()));
//                } else {
//                    App.getRoutes().getDashboard().getHome().go();
//                }
//            })
//            .onError(throwable -> {
////                alert(msg.Error(), throwable.getLocalizedMessage(), () -> {
////                    $this.setState($this.state().password("").submitting(false));
////                });
//            });

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Props / State
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public static class Props extends BaseProps {
        String email;

        @Inject
        public Props() {
        }

        public Props email(final String email) {
            this.email = email;
            return this;
        }
    }

    public static class State {
        String email;
        String password;
        boolean submitting;

        @Inject
        public State() {
        }

        public State email(final String email) {
            this.email = email;
            return this;
        }

        public State password(final String password) {
            this.password = password;
            return this;
        }

        public State submitting(final boolean submitting) {
            this.submitting = submitting;
            return this;
        }

        public boolean canSubmit() {
            return email != null && email.length() > 0 && password != null && password.length() > 0;
        }
    }
}
