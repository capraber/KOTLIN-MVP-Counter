package com.globant.counter.mvp.view


import android.app.Activity
import com.globant.counter.utils.bus.RxBus


class CountView(activity: Activity) : ActivityView(activity) {

    init {
        activity.count_button.setOnClickListener {
            RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        }

        activity.reset_button.setOnClickListener {
            RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        }
    }

    fun setCount(count: String) {
        activity!!.count_label.text = count
    }
}
