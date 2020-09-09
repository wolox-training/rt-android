package ar.com.wolox.android.example.ui.home.news

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private lateinit var newsAdapter: NewsAdapter
    override fun layout(): Int = R.layout.fragment_news

    override fun init() {
        newsAdapter = NewsAdapter(requireContext(), emptyList())
        vNewsRecyclerView.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    val linearLayoutManager = vNewsRecyclerView.layoutManager as LinearLayoutManager
                    val visibleItemsCount = linearLayoutManager.childCount
                    val totalItemCount = linearLayoutManager.itemCount
                    val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
                    presenter.onScrollList(visibleItemsCount, firstVisibleItemPosition, totalItemCount)
                }
            })
        }
        vNewsSwipeRefreshLayout.setOnRefreshListener {
            presenter.isRefreshed()
            vNewsSwipeRefreshLayout.isRefreshing = false
        }
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
}