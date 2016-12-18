package com.experiments.locate.helper.network

import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager

/**
 * Created by Krupal Shah on 17-Dec-16.
 */
object NetworkHelper {

    fun connectivityManager(context: Context)
            = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    fun telephonyManager(context: Context)
            = context.applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?

    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = connectivityManager(context)
        val activeNetworkInfo = connectivityManager?.activeNetworkInfo
        return activeNetworkInfo != null &&
                activeNetworkInfo.isAvailable &&
                activeNetworkInfo.isConnected
    }

    fun isNetworkMetered(context: Context): Boolean {
        val connectivityManager = connectivityManager(context)
        return connectivityManager != null
                && connectivityManager.isActiveNetworkMetered
    }

    fun isLowSpeedNetwork(context: Context): Boolean {
        val telephonyManager = telephonyManager(context)
        val networkType = telephonyManager?.networkType
        when (networkType) {
            TelephonyManager.NETWORK_TYPE_GPRS,
            TelephonyManager.NETWORK_TYPE_EDGE,
            TelephonyManager.NETWORK_TYPE_CDMA,
            TelephonyManager.NETWORK_TYPE_1xRTT,
            TelephonyManager.NETWORK_TYPE_IDEN ->
                //2g networks
                return true
        }
        return false
    }


}