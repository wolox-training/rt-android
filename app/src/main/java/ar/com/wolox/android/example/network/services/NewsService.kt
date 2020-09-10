package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query
import retrofit2.http.Path
import retrofit2.http.Body

interface NewsService {

    @GET("news")
    fun getNews(): Call<List<News>>

    @GET("news")
    fun getSelectedNew(@Query("id") id: Int): Call<List<News>>

    @PUT("news/{id}")
    fun updateNewSelected(
        @Path("id") id: Int,
        @Body news: News
    ): Call<News>
}