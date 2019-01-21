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
        activity.equalsBtn.setOnClickListener {
            RxBus.post(OnEqualsButtonPressedBusObserver.OnEqualsButtonPressed())
        }

        // Reset Listener
        activity.buttonC.setOnClickListener {
            RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed(OpertaionSymbols.EMPTY.symbol))
        }

        // Dot Listener
        activity.dotBtn.setOnClickListener {
            RxBus.post(OnDotButtonPressedBusObserver.OnDotButtonPressed(OpertaionSymbols.DOT.symbol))
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


        // Opertaion Listeners
        activity.addBtn.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(AddOpertaion()))
        }
        activity.substractBtn.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(SubstractOpertaion()))
        }
        activity.divBtn.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(DivideOpertaion()))
        }
        activity.multiplyBtn.setOnClickListener {
            RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(MultipyOpertaion()))
        }


    }

    fun setText(number: String){
        activity!!.displayTxt.text=number
    }
    fun appendText(number: String){
        activity!!.displayTxt.append(number)
    }

    fun resetText(){
        activity!!.displayTxt.text=OpertaionSymbols.EMPTY.symbol
    }
    fun getText(): String{
        return activity!!.displayTxt.text.toString()
    }
    fun showToast(text: String){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }



}