package com.example.hackgsu.activities

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.hackgsu.R
import kotlinx.android.synthetic.main.activity_intro_page.*


class IntroPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)
        supportActionBar?.hide() //byRajul
        intro_signup.setOnClickListener {
            startActivity(Intent(this@IntroPage, MainActivity::class.java))
        }
        intro_signin.setOnClickListener {
            startActivity(Intent(this@IntroPage, SignInPage::class.java))
        }
    }

}