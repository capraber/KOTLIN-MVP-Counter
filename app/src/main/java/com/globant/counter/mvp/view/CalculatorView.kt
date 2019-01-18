package com.globant.counter.mvp.view

import android.app.Activity
import com.globant.counter.rx.OnEqualsButtonPressedBusObserver
import com.globant.counter.rx.OnNumberButtonPressedBusObserver
import com.globant.counter.utils.RxBus
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity){
    init {
        // Equals Listener
        activity.equalsBtn.setOnClickListener {
            RxBus.post(OnEqualsButtonPressedBusObserver.OnEqualsButtonPressed())
        }

        // Number Listener
        activity.btn0.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(0))
        }
        activity.btn1.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        }
        activity.btn2.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(2))
        }
        activity.btn3.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(3))
        }
        activity.btn4.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(4))
        }
        activity.btn5.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(5))
        }
        activity.btn6.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(6))
        }
        activity.btn7.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(7))
        }
        activity.btn8.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(8))
        }
        activity.btn9.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(9))
        }

        // Operation Listener
        activity.resetBtn.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(9))
        }

    }

    fun setText(number: String){
        activity!!.displayTxt.text=number
    }

}