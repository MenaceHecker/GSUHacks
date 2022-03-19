package com.example.hackgsu.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.hackgsu.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide() //byRajul
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(
            {
                val intent = Intent(this, IntroPage::class.java)
                startActivity(intent)
                finish()
            },3000)
    }
}