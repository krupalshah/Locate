package com.experiments.locate.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.experiments.locate.R

/**
 * Created by Krupal Shah on 15-Dec-16.
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