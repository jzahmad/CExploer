package com.example.a3

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.example.a3.cityInfoFragment.ImageFragment
import com.example.a3.cityInfoFragment.LanFragment
import com.example.a3.cityInfoFragment.NameFragment
import com.example.a3.cityInfoFragment.PopFragment

/*
*This activity will hold all the fragments of for name, image, Language and Population.
*/

class CityInfoActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_info_activity)

        // these are the buttons to change fragments
        val nameB: Button = findViewById(R.id.nameButton)
        val imageB: Button = findViewById(R.id.imageButton)
        val lanB: Button = findViewById(R.id.lanButton)
        val popB: Button = findViewById(R.id.popButton)

        // these are the buttons to hold fragments
        // here I used new Instance to send data to fragments.
        val nameF = intent.getStringExtra("cityName")?.let { NameFragment.newInstance(it) }
        val imageF = ImageFragment.newInstance(intent.getIntExtra("cityImage", 0))
        val popF = intent.getStringExtra("cityPop")?.let { PopFragment.newInstance(it) }
        val lanF = intent.getStringExtra("cityLan")?.let { LanFragment.newInstance(it) }

        // On click activities
        nameB.setOnClickListener() {
            if (nameF != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fltext, nameF).commit()
            }
        }
        imageB.setOnClickListener() {
            supportFragmentManager.beginTransaction().replace(R.id.fltext, imageF).commit()
        }
        popB.setOnClickListener() {
            if (popF != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fltext, popF).commit()
            }
        }
        lanB.setOnClickListener() {
            if (lanF != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fltext, lanF).commit()
            }
        }
    }
}

