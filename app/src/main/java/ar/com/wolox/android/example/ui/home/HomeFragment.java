package ar.com.wolox.android.example.ui.home;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * Home Fragment
 */
public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

    public void init(){}
}
