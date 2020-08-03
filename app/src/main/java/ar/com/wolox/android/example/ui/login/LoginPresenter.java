package ar.com.wolox.android.example.ui.login;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    LoginPresenter(){};

    public void onLoginButtonClick(String email, String password) {
        if (email.isEmpty()) {
            getView().showEmailEmptyError();
        }
    }
}
