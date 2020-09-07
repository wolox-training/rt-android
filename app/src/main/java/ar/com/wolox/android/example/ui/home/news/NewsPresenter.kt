package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepository: NewsRepository) : BasePresenter<NewsView>() {

    override fun onViewAttached() {
        val newsList = newsRepository.getNews()
        if (newsList.isEmpty()) {
            view?.showEmptyNews()
        } else {
            view?.showNews(newsList)
        }
    }
}