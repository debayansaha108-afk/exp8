package com.example.intentlogindashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TransactionHistoryFragment : Fragment() {

    private val TAG = "BankMateLifecycle"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "TransactionHistoryFragment: onCreateView")
        val view = inflater.inflate(R.layout.fragment_transaction_history, container, false)

        setupTransaction(view.findViewById(R.id.item1), "12 Sep 2026", "UPI", "₹2,000")
        setupTransaction(view.findViewById(R.id.item2), "08 Sep 2026", "NEFT", "₹5,000")
        setupTransaction(view.findViewById(R.id.item3), "02 Sep 2026", "IMPS", "₹1,500")

        return view
    }

    private fun setupTransaction(view: View, date: String, mode: String, amount: String) {
        view.findViewById<TextView>(R.id.date).text = date
        view.findViewById<TextView>(R.id.mode).text = mode
        view.findViewById<TextView>(R.id.amount).text = amount
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "TransactionHistoryFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "TransactionHistoryFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "TransactionHistoryFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "TransactionHistoryFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "TransactionHistoryFragment: onDestroyView")
    }
}
