package com.example.intentlogindashboard

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        // Basic Profile Views
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Interactive Preference Views
        val notificationSwitch = findViewById<SwitchCompat>(R.id.notificationSwitch)
        val subscribeCheckBox = findViewById<CheckBox>(R.id.subscribeCheckBox)
        val themeRadioGroup = findViewById<RadioGroup>(R.id.themeRadioGroup)
        val fontSizeSeekBar = findViewById<SeekBar>(R.id.fontSizeSeekBar)
        val fontSizeLabel = findViewById<TextView>(R.id.fontSizeLabel)

        val name = intent.getStringExtra("USER_NAME") ?: "User"
        val email = intent.getStringExtra("USER_EMAIL") ?: "No email"

        welcomeTextView.text = "Welcome, $name!"
        nameTextView.text = name
        emailTextView.text = email

        // Listeners for Interactive Views
        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "enabled" else "disabled"
            Toast.makeText(this, "Notifications $status", Toast.LENGTH_SHORT).show()
        }

        subscribeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Subscribed to Newsletter!", Toast.LENGTH_SHORT).show()
            }
        }

        themeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val theme = when (checkedId) {
                R.id.radioLight -> "Light Mode"
                R.id.radioDark -> "Dark Mode"
                else -> "System Default"
            }
            Toast.makeText(this, "Theme set to $theme", Toast.LENGTH_SHORT).show()
        }

        fontSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                fontSizeLabel.text = "Font Size: ${progress}sp"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@DashboardActivity, "Font size set to ${seekBar?.progress}sp", Toast.LENGTH_SHORT).show()
            }
        })

        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
