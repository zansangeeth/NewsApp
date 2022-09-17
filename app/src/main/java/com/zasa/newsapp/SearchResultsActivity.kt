package com.zasa.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search_results.*

class SearchResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        val bundle : Bundle? = intent.extras
        val query = bundle!!.getString("query")
        tvQuery.text = query
    }
}