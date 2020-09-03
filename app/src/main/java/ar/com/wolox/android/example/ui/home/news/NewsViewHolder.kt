package ar.com.wolox.android.example.ui.home.news

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.utils.Dates
import com.facebook.drawee.view.SimpleDraweeView

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_news_row, parent, false)) {

    private var mTitleView: TextView? = null
    private var mImageView: ImageView? = null
    private var mDescriptionView: TextView? = null
    private var mCreatedDateView: TextView? = null
    private var mLikesView: SimpleDraweeView? = null

    init {
        mTitleView = itemView.findViewById(R.id.vNewRowTitle)
        mImageView = itemView.findViewById(R.id.vNewRowImage)
        mDescriptionView = itemView.findViewById(R.id.vNewRowDescription)
        mCreatedDateView = itemView.findViewById(R.id.vNewRowCreatedDate)
        mLikesView = itemView.findViewById(R.id.vNewRowLikes)
    }

    fun bind(news: News) {
        mTitleView?.text = news.title
        mImageView?.setImageURI(Uri.parse(news.picture))
        mDescriptionView?.text = news.text
        mCreatedDateView?.text = Dates.getDaysToDate(news.createdAt).toString().plus("d")
        if ((news.likes.isEmpty())) {
            mLikesView?.hierarchy?.setPlaceholderImage(R.drawable.ic_like_off_large)
        }
    }
}