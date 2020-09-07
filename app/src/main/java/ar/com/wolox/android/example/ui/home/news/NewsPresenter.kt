package ar.com.wolox.android.example.ui.home.news

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepository: NewsRepository) : BasePresenter<NewsView>() {

    private var call: Call<List<News>>? = null
    private lateinit var newsList: List<News>

    override fun onViewAttached() {
        call = newsRepository.getNewsList()
        call?.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                newsList = response.body()!!
                if (newsList.isEmpty()) {
                    view?.showEmptyNews()
                } else {
                    newsList = newsList.plus(newsRepository.getNewsHardcode())
                    view?.showNews(newsList)
                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Log.d("NEWS LIST ERROR", t.message.toString())
                view?.showNetworkError()
            }
        })
    }

    fun onScrollList(linearLayoutManager: LinearLayoutManager) {
        val visibleItemsCount = linearLayoutManager.childCount
        val totalItemCount = linearLayoutManager.itemCount
        val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
        if ((visibleItemsCount + firstVisibleItemPosition) >= (totalItemCount - POS_TO_LOAD_NEW_NEWS) && firstVisibleItemPosition >= 0) {
            view?.showNews(newsRepository.getNewsHardcode())
        }
    }

    fun isRefreshed() {
        view?.showRefreshedNews(newsRepository.getNewsToRefresh())
    }

    companion object {
        const val POS_TO_LOAD_NEW_NEWS = 6
    }
}