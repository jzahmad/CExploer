package com.example.jobboost

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchFilterAdapter(private val infoList: ArrayList<SearchFilterModel>) : RecyclerView.Adapter<SearchFilterAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var companyNameText: TextView = itemView.findViewById(R.id.companyName)
        var jobTitleText: TextView = itemView.findViewById(R.id.jobTitle)
        var responsibilityText: TextView = itemView.findViewById(R.id.responsibility)
        var contactInfoText: TextView = itemView.findViewById(R.id.contactInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = infoList[position]
        holder.companyNameText.text = model.companyName
        holder.jobTitleText.text = model.jobTitle
        holder.responsibilityText.text = model.responsibility
        holder.contactInfoText.text = model.contactInfo
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: ArrayList<SearchFilterModel>) {
        infoList.clear()
        infoList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return infoList.size
    }
}
