package ar.com.wolox.android.example.ui.login;

import android.content.Intent;

interface LoginView {

    void showEmailEmptyError();

    void showPasswordEmptyError();

    void showEmailInvalidError();

    void showUserLoggedMessage(String username);

    void openBrowser(Intent intent);

    void navigateToHomePage();

    void navigateToSignUpPage();
}
