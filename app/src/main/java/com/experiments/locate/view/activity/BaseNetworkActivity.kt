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
