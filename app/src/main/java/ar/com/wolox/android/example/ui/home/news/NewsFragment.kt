package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    override fun layout(): Int = R.layout.fragment_news

    override fun init() {}

    companion object {
        fun newInstance() = NewsFragment()
    }
}