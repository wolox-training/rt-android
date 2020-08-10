package ar.com.wolox.android.example.ui.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * Signup Fragment
 */
public class SignupFragment extends WolmoFragment<SignupPresenter> implements SignupView {

    @Override
    public int layout() {
        return R.layout.fragment_signup;
    }

    @Override
    public void init(){}
}
