package com.example.hackgsu.activities

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackgsu.R
import kotlinx.android.synthetic.main.activity_home_page.*


class home_page : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        supportActionBar?.hide() //byRajul
        buttonch.setOnClickListener {
            startActivity(Intent(this@home_page, Recmain::class.java))

        }
    }

}

