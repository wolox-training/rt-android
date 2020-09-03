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

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_news_row, parent, false)) {

    private var mTitleView: TextView? = null
    private var mImageView: ImageView? = null
    private var mDescriptionView: TextView? = null
    private var mCreatedDateView: TextView? = null
    private var mLikesView: ImageView? = null

    init {
        mTitleView = itemView.findViewById(R.id.vNewRowTitle)
        mImageView = itemView.findViewById(R.id.vNewRowImage)
        mDescriptionView = itemView.findViewById(R.id.vNewRowDescription)
        mCreatedDateView = itemView.findViewById(R.id.vNewRowCreatedDate)
        mLikesView = itemView.findViewById(R.id.vNewRowLikes)
    }

    fun bind(context: Context, news: News) {
        mTitleView?.text = news.title

        Glide.with(context)
            .load(Uri.parse(news.picture))
            .placeholder(R.drawable.wolox_logo)
            .into(mImageView)

        mDescriptionView?.text = news.text
        mCreatedDateView?.text = Dates.getDaysToDate(news.createdAt).toString().plus("d")

        if (news.likes.isEmpty()) {
            Glide.with(context)
                .load(R.drawable.ic_like_on_large)
                .into(mLikesView)
        } else {
            Glide.with(context)
                .load(R.drawable.ic_like_off_large)
                .into(mLikesView)
        }
    }
}