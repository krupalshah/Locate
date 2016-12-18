package com.experiments.locate.helper.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.experiments.locate.helper.network.NetworkHelper.isNetworkConnected
import timber.log.Timber

/**
 * Created by Krupal Shah on 16-Dec-16.
 */

class NetworkChangeReceiver(val networkListener: NetworkListener?) : BroadcastReceiver() {

    //need this ugly flag as for some htc & lg devices,onReceive called multiple times when network switched
    private var wasConnected = false

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent?.action != ConnectivityManager.CONNECTIVITY_ACTION)
            return
        val networkConnected = isNetworkConnected(context)
        notifyListener(networkConnected)
    }

    private fun notifyListener(networkConnected: Boolean?) {
        when (networkConnected) {
            true -> {
                if (wasConnected.not()) {
                    Timber.d("network connected")
                    networkListener?.onNetworkConnected()
                    wasConnected = true
                }
            }
            false -> {
                if (wasConnected) {
                    Timber.d("network disconnected")
                    networkListener?.onNetworkDisConnected()
                    wasConnected = false
                }
            }
        }
    }

}
