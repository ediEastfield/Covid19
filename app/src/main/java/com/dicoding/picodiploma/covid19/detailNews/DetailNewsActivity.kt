package com.dicoding.picodiploma.covid19.detailNews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.covid19.R
import com.dicoding.picodiploma.core.domain.model.Article
import com.dicoding.picodiploma.covid19.databinding.ActivityDetailNewsBinding
import com.dicoding.picodiploma.covid19.webNews.WebNewsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNewsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailNewsViewModel: DetailNewsViewModel by viewModels()

    private lateinit var binding: ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailNews = intent.getParcelableExtra<Article>(EXTRA_DATA)
        showDetailNews(detailNews)
    }

    private fun showDetailNews(detailNews: Article?) {
        detailNews?.let {
            supportActionBar?.title = detailNews.title
            Glide.with(this)
                    .load(detailNews.urlToImage)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(binding.ivDetailImage)
            binding.content.tvDetailDescription.text = detailNews.description
            binding.content.tvDetailTitle.text = detailNews.title
            binding.content.tvDetailPublishedAt.text = detailNews.publishedAt
            binding.content.tvDetailAuthor.text = detailNews.author
            binding.content.tvDetailContent.text = detailNews.content

            binding.content.btnNews.setOnClickListener {
                val intent = Intent(this, WebNewsActivity::class.java)
                intent.putExtra(WebNewsActivity.EXTRA_URL, detailNews.url)
                startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.fab.setOnClickListener {
                statusBookmark = !statusBookmark
                detailNewsViewModel.setBookmarkNews(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun setStatusBookmark(statusBookmark: Boolean) {
        if (statusBookmark) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmark_border_white))
        }
    }
}