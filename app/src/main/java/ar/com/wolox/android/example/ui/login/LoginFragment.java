package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.net.Uri;
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
    private static final String PROTOCOL = "https://";

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
                getPresenter().onTermsConditionsLinkClick();
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
    public void navigateToHomePage() {
        HomeActivity.start(requireContext());
    }

    @Override
    public void navigateToSignUpPage() {
        SignupActivity.start(requireContext());
    }

    @Override
    public void navigateToTermsConditions() {
        String url = getString(R.string.termConditionsUrl);
        if (!url.startsWith(PROTOCOL)) {
            url = PROTOCOL + url;
        }
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setData(Uri.parse(url));
        getActivity().startActivity(intent);
    }

    @Override
    public void showInvalidCredentials() {
        Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
    }
}
