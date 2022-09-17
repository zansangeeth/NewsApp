package com.zasa.newsapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 **@Project -> NewsApp
 **@Author -> Sangeeth on 9/17/2022
 */
class SearchNewsAdapter(val context: Context, val searchNewsList: List<Article>) : RecyclerView.Adapter<SearchNewsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = searchNewsList.size
}