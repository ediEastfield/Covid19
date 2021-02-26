package com.dicoding.picodiploma.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.core.R
import com.dicoding.picodiploma.core.databinding.ItemListNewsBinding
import com.dicoding.picodiploma.core.domain.model.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ListViewHolder>() {

    private var listData = ArrayList<Article>()
    var onItemClick: ((Article) -> Unit)? = null

    fun setData(newListData: List<Article>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int) =
        ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_news, viewGroup, false))

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(listViewHolder: ListViewHolder, position: Int) {
        val data = listData[position]
        listViewHolder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListNewsBinding.bind(itemView)
        fun bind(data: Article) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.urlToImage)
                    .into(ivItemImage)
                tvItemTitle.text = data.title
                tvItemSubtitle.text = data.author
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}