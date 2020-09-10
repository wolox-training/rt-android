package ar.com.wolox.android.example.ui.home.news

import androidx.lifecycle.ViewModel
import ar.com.wolox.android.example.model.News

class NewsViewModel : ViewModel() {

    var newsObject: News? = null

    fun saveNewSelected(newsObjectParam: News) {
        newsObject = newsObjectParam
    }

    fun getNewSelected() = newsObject
}