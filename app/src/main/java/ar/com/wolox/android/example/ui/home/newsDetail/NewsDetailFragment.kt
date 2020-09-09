package ar.com.wolox.android.example.ui.home.newsDetail

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news_detail.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class NewsDetailFragment private constructor() : WolmoFragment<NewsDetailPresenter>(), NewsDetailView {

    override fun layout(): Int = R.layout.fragment_news_detail

    override fun init() {}

    companion object {
        fun newInstance() = NewsDetailFragment()
    }
}