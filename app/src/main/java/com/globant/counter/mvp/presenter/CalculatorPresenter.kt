package com.globant.counter.mvp.presenter

import android.util.Log
import android.widget.Toast
import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.rx.*
import com.globant.counter.utils.AddOpertaion
import com.globant.counter.utils.RxBus

class  CalculatorPresenter(private  val  model: CalculatorModel, private  val view: CalculatorView){

    init {
        val activity =view.activity;
        if (activity!=null){

            // Dot Event
            RxBus.subscribe(activity,object : OnDotButtonPressedBusObserver(){
                override fun onEvent(value: OnDotButtonPressed) {

                    view.setText(value.dot)
                }
            })

            //Reset Event
            RxBus.subscribe(activity,object : OnResetButtonPressedBusObserver(){
                override fun onEvent(value: OnResetButtonPressed) {

                   model.reset()
                   view.setText(value.reset)
                }
            })


            // Equals event
            RxBus.subscribe(activity, object : OnEqualsButtonPressedBusObserver() {
                override fun onEvent(value: OnEqualsButtonPressed) {

                    model.calculate()
                    view.setText("=")
                    Log.v("Equals test","Number1 ${model.firstValue} ${model.operation?.operationSymbol}")

                }
            })

            // Number Event
            RxBus.subscribe(activity,object  : OnNumberButtonPressedBusObserver(){
                override fun onEvent(value: OnNumberButtonPressed) {

                    model.firstValue=value.number.toDouble()
                    view.setText(value.number.toString())
                }

            })

            // IOperation Event
            RxBus.subscribe(activity,object : OnOperationButtonPressedBusObserver(){
                override fun onEvent(value: OnOperationButtonPressedBusObserver.OnOperationButtonPressed) {

                    view.setText(value.operation.operationSymbol)
                    model.operation=value.operation
                    Log.v("Model Test","Operation from model is "+ model.operation?.operationSymbol)
                }
            })

        }
    }

}