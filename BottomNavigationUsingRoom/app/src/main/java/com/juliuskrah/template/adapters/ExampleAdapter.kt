package com.juliuskrah.template.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliuskrah.template.data.domain.ItemModel
import com.juliuskrah.template.databinding.ListItemExampleBinding

class ExampleAdapter internal constructor(
    context: Context
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var items = emptyList<ItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemExampleBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val current = items[position]
        (holder as ItemViewHolder).textHeader.text = current.name
    }

    internal fun setItems(items: List<ItemModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textHeader = ListItemExampleBinding.bind(itemView).fragmentOneCardTextHeader
    }
}