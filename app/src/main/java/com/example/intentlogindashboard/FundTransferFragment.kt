package com.example.intentlogindashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class FundTransferFragment : Fragment() {

    private val TAG = "BankMateLifecycle"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "FundTransferFragment: onCreateView")
        val view = inflater.inflate(R.layout.fragment_fund_transfer, container, false)

        val etName = view.findViewById<EditText>(R.id.etBeneficiaryName)
        val etAcc = view.findViewById<EditText>(R.id.etAccountNumber)
        val etAmount = view.findViewById<EditText>(R.id.etAmount)
        val rgMode = view.findViewById<RadioGroup>(R.id.rgTransferMode)
        val btnConfirm = view.findViewById<Button>(R.id.btnConfirmTransfer)

        btnConfirm.setOnClickListener {
            val name = etName.text.toString()
            val acc = etAcc.text.toString()
            val amount = etAmount.text.toString()
            val selectedId = rgMode.checkedRadioButtonId

            if (name.isEmpty()) {
                etName.error = getString(R.string.err_empty_name)
                return@setOnClickListener
            }
            if (acc.isEmpty()) {
                etAcc.error = getString(R.string.err_empty_acc)
                return@setOnClickListener
            }
            if (amount.isEmpty()) {
                etAmount.error = getString(R.string.err_empty_amount)
                return@setOnClickListener
            }
            if (selectedId == -1) {
                Toast.makeText(requireContext(), R.string.err_select_mode, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val mode = view.findViewById<RadioButton>(selectedId).text.toString()

            val intent = Intent(requireContext(), TransactionActivity::class.java).apply {
                putExtra("BENEFICIARY_NAME", name)
                putExtra("ACCOUNT_NUMBER", acc)
                putExtra("TRANSFER_AMOUNT", amount)
                putExtra("TRANSFER_MODE", mode)
            }
            startActivity(intent)
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "FundTransferFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "FundTransferFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "FundTransferFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FundTransferFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "FundTransferFragment: onDestroyView")
    }
}
