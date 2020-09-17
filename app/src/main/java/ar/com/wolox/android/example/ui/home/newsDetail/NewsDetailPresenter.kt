package ar.com.wolox.android.example.ui.home.newsDetail

import android.util.Log
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsDetailPresenter @Inject constructor(private val newsRepository: NewsRepository) : BasePresenter<NewsDetailView>() {

    private var call: Call<List<News>>? = null
    private var callNew: Call<News>? = null

    override fun onViewAttached() {
        super.onViewAttached()
        newsRepository.getCurrentNews()?.let {
            view?.refreshNewDetailFields(it)
        }
    }

    fun onRefreshNewsDetail() {
        newsRepository.getCurrentNews()?.let {
            call = newsRepository.getSelectedNew(it.id)
            call?.enqueue(object : Callback<List<News>> {
                override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                    val newSelected = response.body()!!
                    if (newSelected.isEmpty()) {
                        view?.showEmptyNewDetail()
                    } else {
                        view?.refreshNewDetailFields(newSelected[0])
                    }
                }

                override fun onFailure(call: Call<List<News>>, t: Throwable) {
                    Log.d(TAG_ERROR, t.message.toString())
                    view?.showNetworkError()
                }
            })
        }
    }

    fun onUpdateLikes() {
        newsRepository.getCurrentNews()?.let {
            if (it.likes.isEmpty()) it.likes = listOf(it.userId) else it.likes = emptyList()
            callNew = newsRepository.updateNew(it.id, it)
            callNew?.enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val newUpdated = response.body()!!
                    view?.refreshNewDetailFields(newUpdated)
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d(TAG_ERROR, t.message.toString())
                    view?.showNetworkError()
                }
            })
        }
    }

    companion object {
        const val TAG_ERROR = "NEWS DETAIL ERROR"
    }
}