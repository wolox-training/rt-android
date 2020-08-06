package ar.com.wolox.android.example.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * Login Fragment
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    private EditText loginEmail;
    private EditText loginPassword;
    private Button loginButton;

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        loginEmail = getView().findViewById(R.id.vEmailInputLogin);
        loginPassword = getView().findViewById(R.id.vPasswordInputLogin);
        loginButton = getView().findViewById(R.id.vButtonLogin);
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
    public void showValidCredentialsMessage() {
        Toast.makeText(requireContext(), "User logged", Toast.LENGTH_SHORT).show();
    }
}
