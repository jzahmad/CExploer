package com.example.jobboost.notificationSettings

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jobboost.R

class MyAdapter(var mutableList: MutableList<String?>, var context: Context): RecyclerView.Adapter<UserJobsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserJobsViewHolder {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.notifications_user_jobs_notification_items_layout, parent, false)
        return UserJobsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: UserJobsViewHolder, position: Int) {

            holder.jobName.setText(mutableList.get(position))
            holder.deleteButton.setOnClickListener {
            mutableList.removeAt(position)
            notifyDataSetChanged()
            Log.i("Message", "Removing at position $position")

        }
    }
}