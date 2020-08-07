package ar.com.wolox.android.example.ui.login;

import android.content.Context;
import android.content.Intent;

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

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
