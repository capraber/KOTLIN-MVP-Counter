package com.globant.counter.mvp.view

import android.app.Activity
import com.globant.counter.mvp.CountContract
import kotlinx.android.synthetic.main.activity_main.countLabel

class CountView(activity: Activity) : ActivityView(activity), CountContract.View{

    override fun setCount(count: String) {
        activity?.countLabel?.text = count
    }
}
