package com.globant.counter.mvp.view

import android.app.Activity
import com.globant.counter.rx.OnEqualsButtonPressedBusObserver
import com.globant.counter.utils.RxBus
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity){
    init {
        // Equals Listener
        activity.equalsBtn.setOnClickListener {
            RxBus.post(OnEqualsButtonPressedBusObserver.OnEqualsButtonPressed())
        }

    }

    fun setText(number: String){
        activity!!.displayTxt.text=number
    }

}