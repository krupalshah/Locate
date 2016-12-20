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

package com.experiments.locate

import com.experiments.locate.helper.reporting.ErrorReporter
import com.orm.SugarApp

/**
 * Created by Krupal Shah on 15-Dec-16.
 *
 * application class
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
