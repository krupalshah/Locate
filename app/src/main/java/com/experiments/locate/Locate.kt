package com.experiments.locate

import com.experiments.locate.helper.reporting.ErrorReporter
import com.orm.SugarApp

/**
 * Created by Krupal Shah on 15-Dec-16.
 */
class Locate : SugarApp() {

    override fun onCreate() {
        super.onCreate()
        ErrorReporter.initialize()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        ErrorReporter.reportBehaviour(message = "onLowMemory() called")
    }


}
