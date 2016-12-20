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

package com.experiments.locate.helper.device

import android.app.ActivityManager
import android.content.Context
import android.support.v4.app.ActivityManagerCompat

/**
 * Created by Krupal Shah on 18-Dec-16.
 *
 * helper class for ram, storage etc. info on device
 */

object DeviceHelper {

    private val outMemoryInfo = ActivityManager.MemoryInfo()

    fun activityManager(context: Context)
            = context.applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    /**
     * return true of device is packed with low ram, false otherwise
     */
    fun isLowRamDevice(context: Context): Boolean
            = ActivityManagerCompat.isLowRamDevice(activityManager(context))

    /**
     * returns true if device is in low ram situation at the time of getting. note that does not indicate that device is already packed with low ram
     */
    fun isLowRamAvailableRightNow(context: Context): Boolean
            = activityManager(context).getMemoryInfo().lowMemory


    fun ActivityManager.getMemoryInfo(): ActivityManager.MemoryInfo {
        getMemoryInfo(outMemoryInfo)
        return outMemoryInfo
    }


}
