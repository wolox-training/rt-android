package ar.com.wolox.android.example.ui.session;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.login.LoginActivity;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * Session Activity
 */
public class SessionActivity extends WolmoActivity {

    @Inject
    UserSession userSession;

    @Override
    public int layout() {
        return R.layout.activity_base;
    }

    @Override
    public void init() {
        if (userSession.getUserIsLogged()) {
            HomeActivity.start(this);
        } else {
            LoginActivity.start(this);
        }
    }
}
