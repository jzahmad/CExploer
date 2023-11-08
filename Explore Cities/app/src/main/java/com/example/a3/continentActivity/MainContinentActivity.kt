package com.example.a3.continentActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3.R

class MainContinentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_list)

        // adapter is recycler and vertical

        val recyclerView: RecyclerView = findViewById(R.id.cities)
        recyclerView.layoutManager=LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        // data source
        val asianCity1= City("Lahore", R.drawable.lahore,"11.13 M","Urdu")
        val asianCity2=City("Karachi",R.drawable.karachi,"14.91 M","Urdu")

        val africaCity1= City("Rabat", R.drawable.rabat,"580 K","Arabic")
        val africaCity2= City("Nairobi", R.drawable.nairobi,"4.3 M","Swahili")

        val europeCity1= City("Paris", R.drawable.paris,"2.16 M","French")
        val europeCity2= City("Barcelona", R.drawable.barcelona,"1.6 M","Spanish")

        val naCity1= City("New York", R.drawable.ny,"8.4 M","English")
        val naCity2= City("Vancouver", R.drawable.vancouver,"675 K","English")

        val saCity1= City("Lima", R.drawable.lima,"11.2 M","Spanish")
        val saCity2= City("Cape Town", R.drawable.cape_town,"4.6 M",
            "Afrikaans\nXhosa\nEnglish\n")

        val cities: Array<City> = when (intent.getStringExtra("continentName")) {
            "Africa" ->arrayOf(africaCity1,africaCity2)
            "Asia" -> arrayOf(asianCity1,asianCity2)
            "Europe" -> arrayOf(europeCity1,europeCity2)
            "North America" -> arrayOf(naCity1,naCity2)
            "South America" -> arrayOf(saCity1,saCity2)
            else -> emptyArray()
        }

        //3- adapter
        val adapter = CityArrayAdapter(cities)
        recyclerView.adapter = adapter
    }
}

