package ar.com.wolox.android.example.ui.home;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * Home Presenter
 */
public class HomePresenter extends BasePresenter<HomeView> {

    private UserSession userSession;

    @Inject
    HomePresenter(UserSession userSession) {
        this.userSession = userSession;
    }

    public void onLogoutLinkClick() {
        userSession.clearEmail(userSession.getEmail());
        getView().logoutHome();
    }
}
