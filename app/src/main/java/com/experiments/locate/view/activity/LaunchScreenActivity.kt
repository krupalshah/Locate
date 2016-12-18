package com.experiments.locate.view.activity

import android.os.Bundle
import com.experiments.locate.helper.storage.PreferenceHelper.defaultPrefs
import com.experiments.locate.helper.storage.PreferenceHelper.get
import com.experiments.locate.helper.storage.PreferenceHelper.set
import com.experiments.locate.util.Consts

/**
 * Created by Krupal Shah on 18-Dec-16.
 */

class LaunchScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //if app introduction has been shown, navigate to home
        val isIntroShown: Boolean? = defaultPrefs(this)[Consts.SharedPrefs.IS_APP_INTRO_SHOWN]
        if (isIntroShown == null || isIntroShown.not()) {
            startActivity(AppIntroActivity.getStartIntent(this))
            defaultPrefs(this)[Consts.SharedPrefs.IS_APP_INTRO_SHOWN] = true
        } else {
            startActivity(HomeActivity.getStartIntent(this))
        }
    }
}
