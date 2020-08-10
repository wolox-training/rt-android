package ar.com.wolox.android.example.ui.home;

import android.content.Context;
import android.content.Intent;

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

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
