package ar.com.wolox.android.example.ui.login;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * Login Activity
 */
public class LoginActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_base;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivityBaseContent, new LoginFragment());
    }
}
