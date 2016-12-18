package com.experiments.locate.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.experiments.locate.R

/**
 * Created by Krupal Shah on 16-Dec-16.
 */

class IntroductionFragment : Fragment() {

    companion object Factory {
        fun newInstance(): Fragment {
            return IntroductionFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
