package ar.com.wolox.android.example.ui.login;

interface LoginView {

    void showEmailEmptyError();

    void showPasswordEmptyError();

    void showEmailInvalidError();

    void navigateToHomePage();

    void navigateToSignUpPage();

    void navigateToTermsConditions();

    void showInvalidCredentials();

    void showNetworkErrorConnection();
}
