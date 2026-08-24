package com.example.intentlogindashboard

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val userName = intent.getStringExtra("USER_NAME")
        val userEmail = intent.getStringExtra("USER_EMAIL")

        tvWelcome.text = "Welcome, $userName!"
        tvName.text = userName
        tvEmail.text = userEmail

        // Show notification after login
        showWelcomeNotification(userName)

        // Logout
        btnLogout.setOnClickListener {

            val logoutIntent = Intent(this, MainActivity::class.java)

            logoutIntent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(logoutIntent)
        }
    }

    private fun showWelcomeNotification(name: String?) {

        val channelId = "welcome_channel"

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create notification channel for Android 8+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                channelId,
                "Welcome Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.description = "Welcome notification after login"

            notificationManager.createNotificationChannel(channel)
        }

        val notification = android.app.Notification.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("🔔 Welcome")
            .setContentText("Welcome ${name ?: "User"}! You have successfully logged in.")
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1001, notification)
    }
}