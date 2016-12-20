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

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.experiments.locate.helper.network.NetworkHelper.isNetworkConnected
import timber.log.Timber

/**
 * Created by Krupal Shah on 16-Dec-16.
 *
 * receiver that needs to be registered at activity level (from 24) in order to receive network updates
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
