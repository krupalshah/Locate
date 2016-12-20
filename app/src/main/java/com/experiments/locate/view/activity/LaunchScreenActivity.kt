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

import android.os.Bundle
import com.experiments.locate.helper.storage.PreferenceHelper.defaultPrefs
import com.experiments.locate.helper.storage.PreferenceHelper.get
import com.experiments.locate.helper.storage.PreferenceHelper.set
import com.experiments.locate.util.Consts

/**
 * Created by Krupal Shah on 18-Dec-16.
 *
 *  activity for launch screen (preferred way for splash screen)
 */

class LaunchScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //if app introduction has been shown, navigate to home
        val isIntroShown: Boolean? = defaultPrefs(this)[Consts.SharedPrefs.IS_APP_INTRO_SHOWN]
        if (isIntroShown == null || isIntroShown.not()) {
            startActivity(AppIntroActivity.getStartIntent(this))
        } else {
            startActivity(HomeActivity.getStartIntent(this))
        }
    }
}
