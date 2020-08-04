package ar.com.wolox.android.example.ui.login;

interface LoginView {

    void showEmailEmptyError();

    void showPasswordEmptyError();

    void showEmailInvalidError();

    void showValidCredentialsMessage();

    void showUserLoggedMessage(String username);
}
