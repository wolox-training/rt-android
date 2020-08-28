package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewsActivity : WolmoActivity() {
    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, NewsFragment.newInstance())
    }
}