package com.example.intentlogindashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        val name = intent.getStringExtra("USER_NAME") ?: "User"
        val email = intent.getStringExtra("USER_EMAIL") ?: "No email"

        welcomeTextView.text = "Welcome, $name!"

        nameTextView.text = "Name: $name"

        emailTextView.text = "Email: $email"

        logoutButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)

            finish()
        }
    }
}