package ar.com.wolox.android.example.ui.session;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SessionModule {

    @ContributesAndroidInjector
    public abstract SessionActivity sessionActivity();
}
