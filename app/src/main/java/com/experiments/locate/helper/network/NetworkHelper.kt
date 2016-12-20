/*
 *    Copyright (c) 2016 Krupal Shah
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.experiments.locate.helper.network

import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager

/**
 * Created by Krupal Shah on 17-Dec-16.
 *
 * helper class for connectivity
 */
object NetworkHelper {

    fun connectivityManager(context: Context)
            = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    fun telephonyManager(context: Context)
            = context.applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?

    /**
     * @return true if network information is available and network is connected, false otherwise
     */
    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = connectivityManager(context)
        val activeNetworkInfo = connectivityManager?.activeNetworkInfo
        return activeNetworkInfo != null &&
                activeNetworkInfo.isAvailable &&
                activeNetworkInfo.isConnected
    }

    /**
     * @return true if network information is available but network is metered. so data charges may apply, false otherwise
     */
    fun isNetworkMetered(context: Context): Boolean {
        val connectivityManager = connectivityManager(context)
        return connectivityManager != null
                && connectivityManager.isActiveNetworkMetered
    }

    /**
     * @return true if device has low bandwidth (2g) connectivity, false otherwise
     */
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