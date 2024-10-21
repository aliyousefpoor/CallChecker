package com.ali.callchecker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager



class CallReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val state = intent!!.getStringExtra(TelephonyManager.EXTRA_STATE)
        if (TelephonyManager.EXTRA_STATE_RINGING == state) {
            val incomingNumber = intent?.let{it.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)}
            if (incomingNumber != null && shouldBlockCall(incomingNumber)) {
                // Logic to block the call
                blockCall(context)
            }
        }
    }

    private fun shouldBlockCall(phoneNumber: String):Boolean {
        // Check if the incoming number has a specific country code
        return phoneNumber.startsWith("+91"); // Example: Block calls from India (+91)
    }

    private fun blockCall(context: Context?) {
        // Blocking a call programmatically isn't straightforward
        // You may disconnect the call using a private API or use other workarounds
    }
}