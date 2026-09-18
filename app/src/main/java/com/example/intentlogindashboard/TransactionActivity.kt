package com.example.intentlogindashboard

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class TransactionActivity : AppCompatActivity() {

    private val TAG = "BankMateLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "TransactionActivity: onCreate")
        setContentView(R.layout.activity_transaction)

        val name = intent.getStringExtra("BENEFICIARY_NAME") ?: ""
        val acc = intent.getStringExtra("ACCOUNT_NUMBER") ?: ""
        val amount = intent.getStringExtra("TRANSFER_AMOUNT") ?: ""
        val mode = intent.getStringExtra("TRANSFER_MODE") ?: ""

        val transId = "BM" + SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())

        setupRow(findViewById(R.id.res_name), "Beneficiary", name)
        setupRow(findViewById(R.id.res_acc), "Account Number", acc)
        setupRow(findViewById(R.id.res_amount), "Amount", "₹$amount")
        setupRow(findViewById(R.id.res_mode), "Mode", mode)
        setupRow(findViewById(R.id.res_id), "Transaction ID", transId)
        setupRow(findViewById(R.id.res_status), "Status", "Successful")

        // Send Notification
        val notificationHelper = NotificationHelper(this)
        notificationHelper.sendTransactionNotification(amount, name, mode)

        findViewById<Button>(R.id.doneButton).setOnClickListener {
            finish()
        }
    }

    private fun setupRow(view: android.view.View, label: String, value: String) {
        view.findViewById<TextView>(R.id.label).text = label
        view.findViewById<TextView>(R.id.value).text = value
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "TransactionActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "TransactionActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "TransactionActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "TransactionActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "TransactionActivity: onDestroy")
    }
}
