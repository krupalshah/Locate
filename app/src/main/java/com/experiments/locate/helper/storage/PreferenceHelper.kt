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

package com.experiments.locate.helper.storage

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Krupal Shah on 17-Dec-16.
 */
object PreferenceHelper {

    private const val DEFAULT_PREFS = "locate_prefs"

    fun defaultPrefs(context: Context): SharedPreferences
            = getPreferences(context = context, name = DEFAULT_PREFS)

    fun getPreferences(context: Context, name: String): SharedPreferences
            = context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    operator fun SharedPreferences.set(key: String, value: Any) {
        when (value) {
            is String -> edit(operation = { editor -> editor.putString(key, value) })
            is Int -> edit(operation = { editor -> editor.putInt(key, value) })
            is Boolean -> edit(operation = { editor -> editor.putBoolean(key, value) })
            is Float -> edit(operation = { editor -> editor.putFloat(key, value) })
            is Long -> edit(operation = { editor -> editor.putLong(key, value) })
        }
    }

    operator inline fun <reified T> SharedPreferences.get(key: String): T? {
        when (T::class) {
            String::class -> getString(key, null)
            Int::class -> getInt(key, -1)
            Boolean::class -> getBoolean(key, false)
            Float::class -> getFloat(key, -1f)
            Long::class -> getLong(key, -1)
        }
        return null
    }

}