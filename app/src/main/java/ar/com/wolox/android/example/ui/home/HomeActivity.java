package ar.com.wolox.android.example.ui.home;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * Home Activity
 */
public class HomeActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_base;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivityBaseContent, new HomeFragment());
    }
}
