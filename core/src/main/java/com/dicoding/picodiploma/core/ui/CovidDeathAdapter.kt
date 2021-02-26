package com.dicoding.picodiploma.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.core.R
import com.dicoding.picodiploma.core.databinding.ItemListCountryBinding
import com.dicoding.picodiploma.core.domain.model.Country
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class CovidDeathAdapter : RecyclerView.Adapter<CovidDeathAdapter.ListViewHolder> () {

    private var listData = ArrayList<Country>()

    fun setData(newListData: List<Country>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        position: Int
    ): ListViewHolder =
        ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_country, viewGroup, false))

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(listViewHolder: ListViewHolder, position: Int) {
        val data = listData[position]
        listViewHolder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListCountryBinding.bind(itemView)
        fun bind(data: Country) {
            with(binding) {
                tvNameCountry.text = data.country
                tvCount.text = NumberFormat.getNumberInstance(Locale("in", "ID")).format(data.deaths)
            }
        }

    }
}