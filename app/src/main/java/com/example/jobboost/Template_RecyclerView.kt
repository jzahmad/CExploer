package com.example.jobboost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class Template_RecyclerView(private val context: Context, private val templates: List<Template_Main.Template>) :
    RecyclerView.Adapter<Template_RecyclerView.TemplateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplateViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.template_item, parent, false)
        return TemplateViewHolder(view)
    }

    override fun onBindViewHolder(holder: TemplateViewHolder, position: Int) {
        val template = templates[position]

        holder.templateName.text = template.name
        holder.templateImage.setImageResource(template.img)

        holder.itemView.setOnClickListener {
            saveSelectedTemplate(template.name)
        }
    }

    override fun getItemCount(): Int {
        return templates.size
    }

    private fun saveSelectedTemplate(templateName: String) {
        val sharedPreferences = context.getSharedPreferences("TemplatePreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("selectedTemplate", templateName)
        editor.apply()
        var i = Intent(context, ResumeBuilderActivity::class.java);
        context.startActivity(i);
    }

    inner class TemplateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val templateImage: ImageView = itemView.findViewById(R.id.templateImage)
        val templateName: TextView = itemView.findViewById(R.id.templateName)
    }
}
