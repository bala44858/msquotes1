package com.example.msquotes1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class trackingQuote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracking_quote)
        findViewById<TextView>(R.id.track).text="hellow ther"
        val username=intent.getStringExtra("userName")
        findViewById<TextView>(R.id.track).text=intent.getStringExtra("userName")
        //findViewById<TextView>(R.id.track).text="hellow ther"
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show()

        findViewById<TextView>(R.id.backbtn).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}