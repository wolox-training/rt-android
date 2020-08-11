package ar.com.wolox.android.example.ui.login;

import android.util.Log;
import android.util.Patterns;

import java.util.List;

import javax.inject.Inject;

import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.requests.UserAdapter;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * LoginPresenter
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private UserSession userSession;
    private boolean validCredentials;
    private static final String TAG_LOGIN_ERROR = "LOGIN ERROR";

    @Inject
    LoginPresenter(UserSession userSession) {
        this.userSession = userSession;
    };

    /**
     * @param email email
     * @param password password
     */
    public void onLoginButtonClick(String email, String password) {
        validCredentials = true;
        validateEmail(email);
        validatePassword(password);
        if (validCredentials) {
            Call<List<User>> call = new UserAdapter().getApiUserService().getLogin(email, password);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        if (response.body().size() == 1) {
                            userSession.setEmail(email);
                            getView().navigateToHomePage();
                        } else {
                            getView().showInvalidCredentials();
                        }
                    } else {
                        Log.d(TAG_LOGIN_ERROR, "Error: " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d(TAG_LOGIN_ERROR, t.getMessage());
                }
            });
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

    public void onTermsConditionsLinkClick() {
        getView().navigateToTermsConditions();
    }
}
