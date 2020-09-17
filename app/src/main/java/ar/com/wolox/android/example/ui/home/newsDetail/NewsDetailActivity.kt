package ar.com.wolox.android.example.ui.home.newsDetail

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class NewsDetailActivity @Inject constructor() : WolmoActivity() {

    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, NewsDetailFragment.newInstance())
    }
}