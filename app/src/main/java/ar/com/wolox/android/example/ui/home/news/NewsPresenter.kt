package ar.com.wolox.android.example.ui.home.news

import android.util.Log
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepository: NewsRepository) : BasePresenter<NewsView>() {

    private var call: Call<List<News>>? = null

    fun getNews() {
        call = newsRepository.getNewsList()
        call?.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                val newsList = response.body()
                if (newsList!!.isEmpty()) {
                    view?.showEmptyNews()
                } else {
                    view?.showNews(newsList)
                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Log.d("NEWS LIST ERROR", t.message.toString())
                view?.showNetworkError()
            }
        })
    }
}