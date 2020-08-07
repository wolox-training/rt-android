package ar.com.wolox.android.example.ui.home;

import android.view.View;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * Home Fragment
 */
public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    private TextView logoutLink;

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

    public void init() {
        logoutLink = getView().findViewById(R.id.vLogoutLink);
    }

    @Override
    public void setListeners() {
        logoutLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onLogoutLinkClick();
            }
        });
    }

    @Override
    public void logoutHome() {
        LoginActivity.start(requireContext());
    }
}
