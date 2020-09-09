package ar.com.wolox.android.example.ui.home;

import ar.com.wolox.android.example.ui.home.news.NewsActivity;
import ar.com.wolox.android.example.ui.home.news.NewsFragment;
import ar.com.wolox.android.example.ui.home.newsDetail.NewsDetailActivity;
import ar.com.wolox.android.example.ui.home.newsDetail.NewsDetailFragment;
import ar.com.wolox.android.example.ui.home.profile.ProfileActivity;
import ar.com.wolox.android.example.ui.home.profile.ProfileFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @ContributesAndroidInjector
    public abstract HomeActivity homeActivity();

    @ContributesAndroidInjector
    public abstract NewsActivity newsActivity();

    @ContributesAndroidInjector
    public abstract ProfileActivity profileActivity();

    @ContributesAndroidInjector
    public abstract HomeFragment homeFragment();

    @ContributesAndroidInjector
    public abstract NewsFragment newsFragment();

    @ContributesAndroidInjector
    public abstract ProfileFragment profileFragment();

    @ContributesAndroidInjector
    public abstract NewsDetailActivity newsDetailActivity();

    @ContributesAndroidInjector
    public abstract NewsDetailFragment newsDetailFragment();

}
