package ar.com.wolox.android.example.ui.home.newsDetail

import android.net.Uri
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.utils.Dates
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_news_detail.*

class NewsDetailFragment private constructor() : WolmoFragment<NewsDetailPresenter>(), NewsDetailView {

    override fun layout(): Int = R.layout.fragment_news_detail
    private var fullScreenImage: Boolean = false

    override fun init() {}

    override fun setListeners() {
        super.setListeners()
        vNewsDetailRefresh.setOnRefreshListener {
            presenter.onRefreshNewsDetail()
        }
        vNewsDetailLike.setOnClickListener {
            presenter.onUpdateLikes()
        }
        vNewsDetailImage.setOnClickListener {
            val imageHeight = if (fullScreenImage) ConstraintLayout.LayoutParams.WRAP_CONTENT else ConstraintLayout.LayoutParams.MATCH_PARENT
            it.layoutParams = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT, imageHeight
            )
            fullScreenImage = !fullScreenImage
        }
        vNewsDetailBack.setOnClickListener {
            requireActivity().onBackPressed()
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

    companion object {
        fun newInstance() = NewsDetailFragment()
    }
}