package ar.com.wolox.android.example.ui.home.news

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.utils.Dates
import com.bumptech.glide.Glide

class NewsAdapter(private val context: Context, private var list: List<News>) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: News = list[position]
        holder.bind(context, news)
    }

    override fun getItemCount(): Int = list.size

    fun clearNews() {
        list = emptyList()
        notifyDataSetChanged()
    }

    fun insertNews(newsToAdd: List<News>) {
        val lastPosition = list.size
        list = list.plus(newsToAdd)
        notifyItemRangeInserted(lastPosition, list.size)
    }
}

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_news_row, parent, false)) {

    private var title: TextView? = null
    private var newImage: ImageView? = null
    private var newDescription: TextView? = null
    private var createdDate: TextView? = null
    private var likes: ImageView? = null

    init {
        title = itemView.findViewById(R.id.vNewRowTitle)
        newImage = itemView.findViewById(R.id.vNewRowImage)
        newDescription = itemView.findViewById(R.id.vNewRowDescription)
        createdDate = itemView.findViewById(R.id.vNewRowCreatedDate)
        likes = itemView.findViewById(R.id.vNewRowLikes)
    }

    fun bind(context: Context, news: News) {
        title?.text = news.title

        Glide.with(context)
                .load(Uri.parse(news.picture))
                .placeholder(R.drawable.wolox_logo)
                .into(newImage)

        newDescription?.text = news.text
        createdDate?.text = Dates.getDaysToDate(news.createdAt).toString().plus("d")

        likes?.isSelected = news.likes.isNotEmpty()
    }
}