package ar.com.wolox.android.example.ui.home

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.newsDetail.NewsDetailFragment
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

class HomeActivity @Inject constructor() : WolmoActivity(), NewsFragment.NewsFragmentListener {

    private var newsDetailFragment = NewsDetailFragment.newInstance()

    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, HomeFragment.newInstance())
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HomeActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }

    override fun onNewsClick(newsSelected: News) {
        newsDetailFragment.setDetailTitle(newsSelected.title)
    }
}