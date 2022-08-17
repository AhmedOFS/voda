package com.example.voda

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class display : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


      val name=  intent.getStringExtra("name")

        val country=  intent.getStringExtra("country")

        val headquarters=  intent.getStringExtra("headquarters")
        val slogan=  intent.getStringExtra("slogan")

        val website=  intent.getStringExtra("website")
        var nameview=findViewById<TextView>(R.id.names)
        nameview.setText(name)
        var countryview=findViewById<TextView>(R.id.country)
        countryview.setText(country)
        var sloganview=findViewById<TextView>(R.id.slogan)
        sloganview.setText(slogan)
        var headview=findViewById<TextView>(R.id.headquarters)
        headview.setText(headquarters)
var visit = findViewById<Button>(R.id.visit)
        visit.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(i)

        }

    }
}