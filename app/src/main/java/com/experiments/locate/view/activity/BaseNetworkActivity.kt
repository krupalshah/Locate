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

package com.experiments.locate.view.activity

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.annotation.CallSuper
import com.experiments.locate.helper.network.NetworkChangeReceiver
import com.experiments.locate.helper.network.NetworkListener

/**
 * Created by Krupal Shah on 17-Dec-16.
 */

abstract class BaseNetworkActivity : BaseActivity(), NetworkListener {

    private var networkChangeReceiver: NetworkChangeReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkChangeReceiver = NetworkChangeReceiver(this)
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        registerReceiver(networkChangeReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        unregisterReceiver(networkChangeReceiver)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        networkChangeReceiver = null
    }

}
