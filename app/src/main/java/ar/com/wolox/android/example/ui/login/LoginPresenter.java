package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.util.Patterns;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * LoginPresenter
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private UserSession userSession;
    private boolean validCredentials;
    private String protocol = "https://";

    @Inject
    LoginPresenter(UserSession userSession) {
        this.userSession = userSession;
    };

    public void onLoginButtonClick(String email, String password) {
        validCredentials = true;
        validateEmail(email);
        validatePassword(password);
        if (validCredentials) {
            userSession.setEmail(email);
            getView().showValidCredentialsMessage();
        }
    }

    private void validateEmail(String email) {
        if (email.isEmpty()) {
            getView().showEmailEmptyError();
            validCredentials = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getView().showEmailInvalidError();
            validCredentials = false;
        }
    }

    private void validatePassword(String password) {
        if (password.isEmpty()) {
            getView().showPasswordEmptyError();
            validCredentials = false;
        }
    }

    public void onSignupButtonClick() {
        getView().navigateToSignUpPage();
    }

    public void onTermsConditionsLinkClick(String url) {
        if (!url.startsWith(protocol)) {
            url = protocol + url;
        }
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        getView().openBrowser(intent);
    }
}
