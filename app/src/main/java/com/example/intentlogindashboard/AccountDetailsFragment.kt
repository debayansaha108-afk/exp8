package com.example.intentlogindashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AccountDetailsFragment : Fragment() {

    private val TAG = "BankMateLifecycle"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "AccountDetailsFragment: onCreateView")
        val view = inflater.inflate(R.layout.fragment_account_details, container, false)

        setupRow(view.findViewById(R.id.row_name), "Customer Name", "Debayan Saha")
        setupRow(view.findViewById(R.id.row_acc), "Account Number", "1234567890")
        setupRow(view.findViewById(R.id.row_type), "Account Type", "Savings Account")
        setupRow(view.findViewById(R.id.row_balance), "Available Balance", "₹50,000")
        setupRow(view.findViewById(R.id.row_branch), "Branch", "Bangalore")
        setupRow(view.findViewById(R.id.row_status), "Status", "Active")

        return view
    }

    private fun setupRow(view: View, label: String, value: String) {
        view.findViewById<TextView>(R.id.label).text = label
        view.findViewById<TextView>(R.id.value).text = value
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AccountDetailsFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AccountDetailsFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AccountDetailsFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AccountDetailsFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "AccountDetailsFragment: onDestroyView")
    }
}
