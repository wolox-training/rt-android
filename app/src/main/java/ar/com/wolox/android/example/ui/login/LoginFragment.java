package ar.com.wolox.android.example.ui.login;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * Login Fragment
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {}
}
