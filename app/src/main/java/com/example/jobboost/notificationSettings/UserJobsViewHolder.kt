package com.example.jobboost.notificationSettings

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobboost.R

class UserJobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var deleteButton = itemView.findViewById<Button>(R.id.delete)
    var jobName = itemView.findViewById<TextView>(R.id.jobName)
}