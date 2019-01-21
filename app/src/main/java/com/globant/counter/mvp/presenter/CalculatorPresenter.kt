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

                    view.appendText(value.dot)
                }
            })

            //Reset Event
            RxBus.subscribe(activity,object : OnResetButtonPressedBusObserver(){
                override fun onEvent(value: OnResetButtonPressed) {

                   model.reset()
                   view.resetText()
                }
            })


            // Equals event
            RxBus.subscribe(activity, object : OnEqualsButtonPressedBusObserver() {
                override fun onEvent(value: OnEqualsButtonPressed) {

                    model.secondValue=view.getText()
                    model.calculate()
                    view.setText(model.calculate())

                    model.reset()

                    //view.showToast("Insert second number")

                }
            })

            // Number Event
            RxBus.subscribe(activity,object  : OnNumberButtonPressedBusObserver(){
                override fun onEvent(value: OnNumberButtonPressed) {

                    //model.calculation?.add(value.number.toString())
                    if(model.operation!=null){
                        view.resetText()
                    }
                    view.appendText(value.number.toString())
                }
            })

            // IOperation Event
            RxBus.subscribe(activity,object : OnOperationButtonPressedBusObserver(){
                override fun onEvent(value: OnOperationButtonPressedBusObserver.OnOperationButtonPressed) {

                    if(view.getText().isEmpty() || model.operation!=null){

                        view.showToast("Must select one number first")

                    }else {
                        model.firstValue=view.getText()

                        model.operation = value.operation
                        view.setText(value.operation.operationSymbol)

                        Log.v("Model Test", "Operation from model is ${model.firstValue}" +
                                " ${model.operation?.operationSymbol}")
                    }
                }
            })

        }
    }

}