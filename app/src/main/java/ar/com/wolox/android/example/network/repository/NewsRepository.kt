package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.network.services.NewsService
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import javax.inject.Inject

class NewsRepository @Inject constructor(private val retrofitServices: RetrofitServices) {

    private val service: NewsService
        get() = retrofitServices.getService(NewsService::class.java)

    fun getNewsList() = service.getNews()
}