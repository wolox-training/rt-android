package ar.com.wolox.android.example.ui.signup;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SignupModule {

    @ContributesAndroidInjector
    public abstract SignupActivity signupActivity();

    @ContributesAndroidInjector
    public abstract SignupFragment signupFragment();
}
