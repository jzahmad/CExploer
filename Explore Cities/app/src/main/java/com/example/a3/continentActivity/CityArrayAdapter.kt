package com.example.a3.continentActivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3.CityInfoActivity
import com.example.a3.R
/*
*This is the City adapter. It's main purpose is to make a card-view of cities while those cards are
* in recycler view.
*/
class CityArrayAdapter(private val cities: Array<City>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.cityImage)
        var text: TextView = itemView.findViewById(R.id.cityName)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.city_card,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val context = holder.itemView.context

        holder.itemView.findViewById<ImageView>(R.id.cityImage).setImageResource(cities[position].image)
        holder.itemView.findViewById<TextView>(R.id.cityName).text = cities[position].name

        /*
        * Onclick those cards it send data through intent to cityInfoActivity.
        */
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CityInfoActivity::class.java)
            intent.putExtra("cityImage", cities[position].image)
            intent.putExtra("cityName", cities[position].name)
            intent.putExtra("cityPop", cities[position].population)
            intent.putExtra("cityLan", cities[position].language)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return cities.size
    }

}
