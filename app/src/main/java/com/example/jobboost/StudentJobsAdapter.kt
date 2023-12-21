package com.example.jobboost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentJobsAdapter(private val dataList: List<StudentJobPosting>) :
    RecyclerView.Adapter<StudentJobsAdapter.YourViewHolder>() {

    var onItemClick: ((StudentJobPosting) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_job_card, parent, false)
        return YourViewHolder(view)
    }

    override fun onBindViewHolder(holder: YourViewHolder, position: Int) {
        val data = dataList[position]
        // Bind data to the views in the ViewHolder
        holder.jobTitleTextView.text = data.jobTitle
        holder.companyNameTextView.text = data.companyName
        holder.jobLocationTextView.text = data.jobLocation

        // Set click listener
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(data)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class YourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitleTextView: TextView = itemView.findViewById(R.id.jobTitleTextView)
        val companyNameTextView: TextView = itemView.findViewById(R.id.companyNameTextView)
        val jobLocationTextView: TextView = itemView.findViewById(R.id.jobLocationTextView)
    }
}
