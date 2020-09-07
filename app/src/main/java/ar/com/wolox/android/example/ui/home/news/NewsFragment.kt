package ar.com.wolox.android.example.ui.home.news

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    override fun layout(): Int = R.layout.fragment_news

    override fun init() {
        vNewsRecyclerView.layoutManager = LinearLayoutManager(activity)
        vNewsSwipeRefreshLayout.setOnRefreshListener {
            vNewsSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun showEmptyNews() {
        Toast.makeText(requireContext(), "Don't exists news to show.", Toast.LENGTH_SHORT).show()
    }

    override fun showNews(newsList: List<News>) {
        vNewsRecyclerView.adapter = NewsAdapter(requireContext(), newsList)
    }

    override fun showNetworkError() {
        Toast.makeText(requireContext(), "Network connection error", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}