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

    private EditText loginInputEmail;
    private EditText loginInputPassword;
    private Button loginButton;

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        loginInputEmail = getView().findViewById(R.id.vEmailInputLogin);
        loginInputPassword = getView().findViewById(R.id.vPasswordInputLogin);
        loginButton = getView().findViewById(R.id.vButtonLogin);
    }

    @Override
    public void setListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onLoginButtonClick(
                    loginInputEmail.getText().toString().trim(),
                    loginInputPassword.getText().toString().trim()
                );
            }
        });
    }

    @Override
    public void showEmail(String email) {
        Toast.makeText(requireContext(), email, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmailEmptyError() {
        loginInputEmail.setError("Email can't be empty");
    }
}
