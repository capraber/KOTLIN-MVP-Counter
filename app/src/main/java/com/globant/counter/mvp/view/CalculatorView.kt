package com.globant.counter.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import com.globant.counter.rx.*
import com.globant.counter.utils.*
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity){
    init {
        // Equals Listener
        activity.button_equals.setOnClickListener {
            RxBus.post(OnEqualsButtonPressedBusObserver.OnEqualsButtonPressed())
        }

        // Reset Listener
        activity.button_reset.setOnClickListener {
            RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        }

        // Dot Listener
        activity.button_dot.setOnClickListener {
            RxBus.post(OnDotButtonPressedBusObserver.OnDotButtonPressed(OpertaionSymbols.DOT.symbol))
        }

        // Number Listener
        activity.button_cero.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(0))
        }
        activity.button_one.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        }
        activity.button_two.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(2))
        }
        activity.button_three.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(3))
        }
        activity.button_four.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(4))
        }
        activity.button_five.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(5))
        }
        activity.button_six.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(6))
        }
        activity.button_seven.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(7))
        }
        activity.button_eight.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(8))
        }
        activity.button_nine.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(9))
        }


        // Opertaion Listeners
        activity.button_addition.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(AddOpertaion()))
        }
        activity.button_subtraction.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(SubstractOpertaion()))
        }
        activity.button_division.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(DivideOpertaion()))
        }
        activity.button_multiplication.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(MultipyOpertaion()))
        }


    }

    fun setText(number: String){
        activity!!.text_display.text=number
    }
    fun appendText(number: String){
        activity!!.text_display.append(number)
    }

    fun resetText(){
        activity!!.text_display.text=OpertaionSymbols.EMPTY.symbol
    }
    fun getText(): String{
        return activity!!.text_display.text.toString()
    }
    fun showToast(text: String){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }



}