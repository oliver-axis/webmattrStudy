package client.modules.auth.login;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.StyleElement;
import com.google.gwt.dom.client.StyleInjector;
import jsinterop.annotations.JsProperty;
import client.i18n.AuthMessages;
import client.modules.auth.AuthShell;
import webmattr.dom.CSSProps;
import webmattr.react.ReactComponent;
import webmattr.react.ReactElement;
import webmattr.react.Ref;
import webmattr.router.RouteComponent;
import webmattr.router.RouteProps;
import webmattr.router.RouteProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

import static webmattr.dom.DOM.*;

/**
 *
 */
@Singleton
public class LoginPage extends RouteComponent<LoginPage.Route, LoginPage.Args, LoginPage.Props, LoginPage.State> {
    private static final String bodyCss = "page-login-v2 layout-full page-dark";
    private final AuthMessages msg = AuthMessages.instance;
    private final Ref<StyleElement> pageStyleRef = Ref.make();

    @Inject
    public LoginPage() {
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Render
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    protected ReactElement render(ReactComponent $this, Props props, State state) {
        return div($ -> $.className("page"),
                div($ -> $.className("page-content"),
                        div($ -> $.className("page-brand-info"),
                                div($ -> $.className("brand"),
//                                                img($ -> $.className("brand-img").src("images/grunt.png")),
                                        h2($ -> $.className("brand-text font-size-40").style(new CSSProps().marginLeft("0 !important")), msg.MoveMedical())
                                ),
                                p($ -> $.className("font-size-20"), "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                        ),
                        div($ -> $.className("page-login-main"),
                                div($ -> $.className("brand visible-xs text-center"),
//                                                img($ -> $.className("brand-img").src("images/grunt.png")),
                                        h3($ -> $.className("brand-text font-size-40").style(new CSSProps().marginLeft("0 !important")), msg.MoveMedical())
                                ),
                                h3($ -> $.className("font-size-24"), "Sign In"),
                                p("Lorem ipsum dolor sit amet, consectetur adipisicing elit."),
                                p(msg.NoAccountQuestionMark(), a($ -> $.className("margin-left-5"), msg.SignUp())),
                                footer($ -> $.className("page-copyright"),
                                        p(msg.MoveMedical()),
                                        p(msg.CopyrightIconYearAllRightsReserved(2016))
                                )
                        )
                )
        );
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void componentWillMount(ReactComponent<Props, State> $this, Props props, State state) {
        super.componentWillMount($this, props, state);
        Document.get().getBody().addClassName(bodyCss);
//        pageStyleRef.set($this, StyleInjector.injectStylesheet(RemarkBundle.INSTANCE.css_pages_login_v2().getText()));
    }

    @Override
    protected void componentWillUnmount(ReactComponent<Props, State> $this) {
        super.componentWillUnmount($this);
        Document.get().getBody().removeClassName(bodyCss);
//        pageStyleRef.get($this, StyleElement::removeFromParent);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Args / Props / State / Route
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public static class Args {
        @JsProperty
        String email;

        @Inject
        public Args() {
        }

        public Args email(final String email) {
            this.email = email;
            return this;
        }
    }

    public static class Props extends RouteProps<Args> {
        @Inject
        public Props() {
        }
    }

    public static class State {
        @Inject
        public State() {
        }
    }

    public static class Route extends RouteProxy<Args> {
        @Inject
        public Route(AuthShell.Route parent) {
            super("login", parent);
        }
    }
}
