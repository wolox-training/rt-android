package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.signup.SignupActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * Login Fragment
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    private EditText loginEmail;
    private EditText loginPassword;
    private Button loginButton;
    private Button signupButton;
    private TextView termsConditionsLink;

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        loginEmail = getView().findViewById(R.id.vEmailInputLogin);
        loginPassword = getView().findViewById(R.id.vPasswordInputLogin);
        loginButton = getView().findViewById(R.id.vButtonLogin);
        signupButton = getView().findViewById(R.id.vButtonSignUp);
        termsConditionsLink = getView().findViewById(R.id.vTermsAndConditionsLoginLink);

        getPresenter().checkIfUserLogged(loginEmail.toString().trim());
    }

    @Override
    public void setListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onLoginButtonClick(
                    loginEmail.getText().toString().trim(),
                    loginPassword.getText().toString().trim()
                );
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onSignupButtonClick();
            }
        });
        termsConditionsLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onTermsConditionsLinkClick(getString(R.string.termConditionsUrl));
            }
        });
    }

    @Override
    public void showEmailEmptyError() {
        loginEmail.setError(getString(R.string.emailEmptyError));
    }

    @Override
    public void showEmailInvalidError() {
        loginEmail.setError(getString(R.string.emailInvalidError));
    }

    @Override
    public void showPasswordEmptyError() {
        loginPassword.setError(getString(R.string.passwordEmptyError));
    }

    @Override
    public void showUserLoggedMessage(String username) {
        Toast.makeText(requireContext(), "User " + username + " is logged", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openBrowser(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void navigateToHomePage() {
        HomeActivity.start(requireContext());
    }

    @Override
    public void navigateToSignUpPage() {
        SignupActivity.start(requireContext());
    }
}
