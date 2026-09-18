package com.example.intentlogindashboard

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class AccountActivity : AppCompatActivity() {

    private val TAG = "BankMateLifecycle"
    private val PERMISSION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "AccountActivity: onCreate")
        setContentView(R.layout.activity_account)

        // Request permission for Android 13+
        requestNotificationPermission()

        // Default fragment
        replaceFragment(AccountDetailsFragment())

        findViewById<View>(R.id.btnNavDetails).setOnClickListener {
            replaceFragment(AccountDetailsFragment())
        }

        findViewById<View>(R.id.btnNavTransfer).setOnClickListener {
            replaceFragment(FundTransferFragment())
        }

        findViewById<View>(R.id.btnNavHistory).setOnClickListener {
            replaceFragment(TransactionHistoryFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), PERMISSION_REQUEST_CODE)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AccountActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AccountActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AccountActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AccountActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AccountActivity: onDestroy")
    }
}
