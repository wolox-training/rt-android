package ar.com.wolox.android.example.ui.home.news

import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.home.newsDetail.NewsDetailFragment
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView, NewsAdapter.NewsClickListener {

    private lateinit var newsAdapter: NewsAdapter
    override fun layout(): Int = R.layout.fragment_news

    override fun init() {
        newsAdapter = NewsAdapter(requireContext(), emptyList(), this)
        vNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter
        }
        vNewsSwipeRefreshLayout.setOnRefreshListener {
            presenter.isRefreshed()
            vNewsSwipeRefreshLayout.isRefreshing = false
        }
        vNewsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val linearLayoutManager = vNewsRecyclerView.layoutManager as LinearLayoutManager
                presenter.onScrollList(linearLayoutManager)
            }
        })
    }

    override fun showEmptyNews() {
        Toast.makeText(requireContext(), "Don't exists news to show.", Toast.LENGTH_SHORT).show()
    }

    override fun showNews(newsList: List<News>) {
        newsAdapter.insertNews(newsList)
    }

    override fun showNetworkError() {
        Toast.makeText(requireContext(), "Network connection error", Toast.LENGTH_SHORT).show()
    }

    override fun showRefreshedNews(newsToRefresh: List<News>) {
        newsAdapter.clearNews()
        newsAdapter.insertNews(newsToRefresh)
    }

    companion object {
        fun newInstance() = NewsFragment()
    }

    override fun onNewsClickListener(data: News) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.vActivityBaseContent, NewsDetailFragment.newInstance())
            ?.addToBackStack(null)?.commit()
    }
}