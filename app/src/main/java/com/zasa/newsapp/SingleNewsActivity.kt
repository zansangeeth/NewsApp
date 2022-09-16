package com.zasa.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_single_news.*

class SingleNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_news)

        val bundle: Bundle? = intent.extras

        val image = bundle!!.getString("image")
        val time = bundle.getString("time")
        val title = bundle.getString("title")
        val author = bundle.getString("author")
        val description = bundle.getString("description")

        Glide.with(applicationContext).load(image).into(ivSingleNews)
        tvNewsUpdatedTime.text = time
        tvSingleNewsTitle.text = title
        tvSingleNewsPublishedBy.text = author
        tvSingleNewsDescription.text = description

        fabAddToFavourite.setOnClickListener {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        }

    }
}