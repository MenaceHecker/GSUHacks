package com.example.hackgsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro_page.*

class IntroPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)
        supportActionBar?.hide() //byRajul
        intro_signup.setOnClickListener {
            startActivity(Intent(this@IntroPage,MainActivity::class.java))
        }
        intro_signin.setOnClickListener {
            startActivity(Intent(this@IntroPage,SignInPage::class.java))
        }
    }
}