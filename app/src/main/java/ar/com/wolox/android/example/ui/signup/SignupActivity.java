package ar.com.wolox.android.example.ui.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * Signup Activity
 */
public class SignupActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_base;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivityBaseContent, new SignupFragment());
    }
}
