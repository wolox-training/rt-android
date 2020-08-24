package ar.com.wolox.android.example.ui.login;

import android.util.Log;
import android.util.Patterns;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.repository.UserRepository;
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
    private UserRepository userRepository;
    private boolean validCredentials;
    private static final String TAG_LOGIN_ERROR = "LOGIN ERROR";

    @Inject
    LoginPresenter(
        UserSession userSession,
        UserRepository userRepository
    ) {
        this.userSession = userSession;
        this.userRepository = userRepository;
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
            Call<List<User>> call = userRepository.service().getLogin(email, password);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        if (response.body().isEmpty()) {
                            getView().showInvalidCredentials();
                        } else {
                            userSession.setEmail(email);
                            getView().navigateToHomePage();
                        }
                    } else {
                        Log.d(TAG_LOGIN_ERROR, "Error: " + response.code());
                    }
                }

                @Override
                public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                    Log.d(TAG_LOGIN_ERROR, t.getMessage());
                    getView().showNetworkErrorConnection();
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
