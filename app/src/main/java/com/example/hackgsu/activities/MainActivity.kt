package com.example.hackgsu.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.hackgsu.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_intro_page.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide() //byRajul
        btn_signin.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignInPage::class.java))

        btn_register.setOnClickListener{


            when{
                TextUtils.isEmpty(register_email.toString().trim{ it <=' '}) ->{
                    Toast.makeText(
                        this@MainActivity,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(register_password.toString().trim{ it<=' ' }) -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val email: String = register_email.text.toString().trim{ it <= ' '}
                    val password: String = register_password.text.toString().trim{ it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!





                                    Toast.makeText(
                                        this@MainActivity,
                                        "You are registered successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val intent =
                                        Intent( this@MainActivity, IntroPage::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@MainActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                }

                            }
                        )
                }
            }
        }
    }}}


