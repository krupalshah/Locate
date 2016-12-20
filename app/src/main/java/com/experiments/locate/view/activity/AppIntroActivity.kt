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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.experiments.locate.R

/**
 * Created by Krupal Shah on 15-Dec-16.
 *
 * activity for app introduction
 */
class AppIntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }

    companion object Factory {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AppIntroActivity::class.java)
        }
    }


}