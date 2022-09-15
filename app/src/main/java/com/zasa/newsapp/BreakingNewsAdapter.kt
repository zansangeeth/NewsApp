package com.zasa.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 **@Project -> NewsApp
 **@Author -> Sangeeth on 9/15/2022
 */
class BreakingNewsAdapter(val context: Context, private val breakingNewsList: List<NewsData>) :
    RecyclerView.Adapter<BreakingNewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(breakingNews: NewsData) {
            itemView.findViewById<TextView>(R.id.tvUsername).text = breakingNews.articles[position].author
            itemView.findViewById<TextView>(R.id.tvHeadline).text = breakingNews.articles[position].title
            itemView.findViewById<TextView>(R.id.tvPublishedAt).text = breakingNews.articles[position].publishedAt
            Glide.with(context).load(breakingNews.articles[position].urlToImage).into(itemView.findViewById(R.id.ivBreakingNes))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_latest, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breakingNews = breakingNewsList[position]
        holder.bind(breakingNews)
    }

    override fun getItemCount() = breakingNewsList.size
}