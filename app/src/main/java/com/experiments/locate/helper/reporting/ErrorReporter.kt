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

package com.experiments.locate.helper.reporting

import android.util.Log
import com.experiments.locate.BuildConfig
import com.google.firebase.crash.FirebaseCrash
import timber.log.Timber

/**
 * Created by Krupal Shah on 16-Dec-16.
 *
 * pluggable reporter for non fatal errors & behavioural conditions
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
     * reports any behavioural message
     */
    fun reportBehaviour(message: String) = FirebaseCrash.log(message)

    /**
     * reports cached exceptions
     */
    fun reportNonFatal(error: Throwable) = FirebaseCrash.report(error)


}