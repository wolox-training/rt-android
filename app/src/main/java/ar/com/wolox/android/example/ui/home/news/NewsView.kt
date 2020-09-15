package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.News

interface NewsView {
    fun showEmptyNews()
    fun showNews(newsList: List<News>)
    fun showNetworkError()
    fun showRefreshedNews(newsToRefresh: List<News>)
    fun goToSelectedNews()
}