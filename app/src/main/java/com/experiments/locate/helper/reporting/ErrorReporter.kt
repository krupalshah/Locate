package com.experiments.locate.helper.reporting

import android.util.Log
import com.experiments.locate.BuildConfig
import com.google.firebase.crash.FirebaseCrash
import timber.log.Timber

/**
 * Created by Krupal Shah on 16-Dec-16.
 *
 * pluggable non fatal errors & behaviour reporter for app
 * currently using timber as logger & firebase as crash reporter
 */
object ErrorReporter {

    /**
     * tree that observes log & automatically reports logged exceptions
     */
    private val errorReportingTree = object : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String?, throwable: Throwable?) {
            when (priority) {
                Log.ERROR ->
                    if (throwable != null) reportNonFatal(throwable)
            }
        }
    }

    /**
     * enables logging if in debug mode
     * otherwise enables reporting non fatal errors
     */
    fun initialize() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(errorReportingTree)
        }
    }

    /**
     * to report any behavioural message
     */
    fun reportBehaviour(message: String) = FirebaseCrash.log(message)

    /**
     * to report cached exceptions
     */
    fun reportNonFatal(error: Throwable) = FirebaseCrash.report(error)


}