package com.example.indonesianews.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.core.domain.model.News
import com.example.indonesianews.R
import com.example.indonesianews.databinding.ActivityDetailNewsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    private val detailNewsViewModel: DetailNewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        val detailTourism = intent.getParcelableExtra<News>(EXTRA_DATA)
        Log.d(TAG, "detailTourism: isBookmark ${detailTourism?.isBookmark}")
        showDetailNews(detailTourism)
    }

    private fun setToolbar() {
        supportActionBar?.apply {
            title = "Detail News"
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showDetailNews(detailNews: News?) {
        detailNews?.let {
            with(binding) {
                tvTitle.text = detailNews.title
                tvDesc.text = detailNews.description
                tvContent.text = detailNews.content
                tvUrl.text = detailNews.url

                tvUrl.setOnClickListener {
                    startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(detailNews.url))
                    )
                }

                Glide.with(this@DetailNewsActivity)
                    .load(detailNews.urlToImage)
                    .into(ivNews)
            }


            var statusBookmark = detailNews.isBookmark
            Log.d(TAG, "Bookmark status: $statusBookmark")
            setBookmark(statusBookmark)
            binding.btnBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailNewsViewModel.setBookmarkNews(detailNews, statusBookmark)
                setBookmark(statusBookmark)
            }
        }
    }

    private fun setBookmark(status: Boolean) {
        if (status) {
            binding.btnBookmark.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmark))
        } else {
            binding.btnBookmark.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_bookmark))
        }
    }

    companion object {
        const val TAG = "DetailNewsActivity"
        const val EXTRA_DATA = "extra_data"

    }

}