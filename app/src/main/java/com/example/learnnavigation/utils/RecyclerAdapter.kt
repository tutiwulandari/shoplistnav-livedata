package com.example.learnnavigation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnnavigation.R
import kotlinx.android.synthetic.main.card_view.view.*

class RecyclerAdapter(val items : MutableList<Items>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val ItemName: TextView = itemView.tvItemName
        val ItemDate : TextView = itemView.tvDate
        val ItemQuantity: TextView = itemView.tvQuantity
        val ItemPrice: TextView = itemView.tvPrice

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.getContext())
        val view = layoutInflater.inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//      val currentItem = ItemList[position]
//        holder.ItemName.text = currentItem.name
       holder.ItemName.setText(items.get(position).name)
        holder.ItemDate.setText(items.get(position).date)
        holder.ItemQuantity.setText(items.get(position).quantity)
        holder.ItemPrice.setText(items.get(position).price)

    }


}