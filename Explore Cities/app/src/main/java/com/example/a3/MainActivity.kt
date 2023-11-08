package com.example.a3
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import com.example.a3.continentActivity.MainContinentActivity

/*
* This is first activity where it works on the function whenever you press a continent.
* It used a listview to host the continents names and then transfer it to continents activity
* through intents.
*/

class MainActivity:  ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        var listview : ListView =findViewById(R.id.listview)

        //list of continents
        val continent= arrayOf(
            "Africa", "Asia", "Europe",
            "North America", "South America")

        val arrayAdapter : ArrayAdapter<String> =ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            continent
        )
        listview.adapter=arrayAdapter

        // Here whenever we click the continent name it's send the name through intent.
        listview.setOnItemClickListener { _, _, position, _ ->
            val selectedContinent = continent[position]
            val intent = Intent(this, MainContinentActivity::class.java)
            intent.putExtra("continentName", selectedContinent)
            startActivity(intent)
        }

    }
}