package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.sharedpreference.Session.LoginPref

class MainActivity : AppCompatActivity() {
    private lateinit var tvUserName : TextView
    private lateinit var tvEmail : TextView
    private lateinit var btnLogout : Button

    lateinit var session : LoginPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session = LoginPref(this)
        tvUserName = findViewById(R.id.tvUserName)
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        session.checkLogin()
        var user : HashMap<String , String> = session.getUserDetails()
        var username = user.get(LoginPref.KEY_USERNAME)
        var email = user.get(LoginPref.KEY_EMAIL)
        tvUserName.setText(username)
        tvEmail.setText(email)

        btnLogout.setOnClickListener {
            session.LogutUser()
        }
    }
}