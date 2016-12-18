package com.experiments.locate.helper.device

import android.app.ActivityManager
import android.content.Context
import android.support.v4.app.ActivityManagerCompat

/**
 * Created by Krupal Shah on 18-Dec-16.
 */

object DeviceUtil {

    private val outMemoryInfo = ActivityManager.MemoryInfo()

    fun activityManager(context: Context)
            = context.applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    fun isLowRamDevice(context: Context): Boolean
            = ActivityManagerCompat.isLowRamDevice(activityManager(context))

    fun isLowRamAvailableRightNow(context: Context): Boolean
            = activityManager(context).getMemoryInfo().lowMemory


    fun ActivityManager.getMemoryInfo(): ActivityManager.MemoryInfo {
        getMemoryInfo(outMemoryInfo)
        return outMemoryInfo
    }


}
