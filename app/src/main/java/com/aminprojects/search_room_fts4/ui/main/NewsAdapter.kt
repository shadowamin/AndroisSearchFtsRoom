package com.aminprojects.search_room_fts4.ui.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aminprojects.search_room_fts4.R
import com.aminprojects.search_room_fts4.data.room.entity.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.RecyclerViewHolder>() {

    var cardsList = listOf<News>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return RecyclerViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val news = cardsList[position]
        val itemView = holder.itemView
        itemView.title.text = news.title
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}