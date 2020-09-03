package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.example.model.News

class NewsAdapter(private val list: List<News>) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: News = list[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int = list.size
}