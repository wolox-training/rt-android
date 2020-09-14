package ar.com.wolox.android.example.ui.home.newsDetail

import ar.com.wolox.android.example.model.News

interface NewsDetailView {
    fun showNetworkError()
    fun showEmptyNewDetail()
    fun refreshNewDetailFields(news: News)
    fun setTitle(title: String)
}