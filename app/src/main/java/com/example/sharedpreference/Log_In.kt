package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sharedpreference.Session.LoginPref

class Log_In : AppCompatActivity() {
    private lateinit var etUsername : EditText
    private lateinit var etEmail : EditText
    private lateinit var btnLogin : Button
    lateinit var session : LoginPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        session = LoginPref(this)
        if(session.isLoggedin()){
            var i : Intent = Intent(applicationContext, MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            var username = etUsername.text.toString().trim()
            var email = etEmail.text.toString().trim()
            if (username.isEmpty() && email.isEmpty()){
                Toast.makeText(this,"Login Failed Please Try Again", Toast.LENGTH_SHORT).show()
            }
            else{
                session.createLoginSession(username, email)
                var i : Intent = Intent(applicationContext ,MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
}