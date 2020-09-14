package ar.com.wolox.android.example.ui.home.newsDetail

import android.net.Uri
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.home.news.NewsViewModel
import ar.com.wolox.android.example.utils.Dates
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_news_detail.*

class NewsDetailFragment private constructor() : WolmoFragment<NewsDetailPresenter>(), NewsDetailView {

    private val newsViewModel: NewsViewModel by activityViewModels()

    override fun layout(): Int = R.layout.fragment_news_detail

    override fun init() {
        val newSelected = newsViewModel.getNewSelected()
        populateViewFields(newSelected!!)
        vNewsDetailRefresh.setOnRefreshListener {
            presenter.onRefreshNewsDetail(newSelected.id)
        }
        vNewsDetailLike.setOnClickListener {
            presenter.onUpdateLikes(newSelected.id, newSelected)
        }
        vNewsDetailImage.setOnClickListener {
            it.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun populateViewFields(newSelected: News) {
        newSelected.run {
            Glide.with(requireContext())
                    .load(Uri.parse(picture))
                    .placeholder(R.drawable.wolox_logo)
                    .into(vNewsDetailImage)
            vNewsDetailTitle.text = title
            vNewsDetailText.text = text
            vNewsDetailDate.text = Dates.getDaysToDate(createdAt).toString().plus("d")
            vNewsDetailLike.isSelected = newSelected.likes.isNotEmpty()
        }
    }

    override fun showNetworkError() {
        Toast.makeText(requireContext(), getString(R.string.networkConnectionError), Toast.LENGTH_SHORT).show()
        vNewsDetailRefresh.isRefreshing = false
    }

    override fun showEmptyNewDetail() {
        Toast.makeText(requireContext(), getString(R.string.newsNotFound), Toast.LENGTH_SHORT).show()
        vNewsDetailRefresh.isRefreshing = false
    }

    override fun refreshNewDetailFields(news: News) {
        populateViewFields(news)
        vNewsDetailRefresh.isRefreshing = false
    }

    companion object {
        fun newInstance() = NewsDetailFragment()
    }
}