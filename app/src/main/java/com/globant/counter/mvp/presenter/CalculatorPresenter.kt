package com.globant.counter.mvp.presenter

import android.util.Log
import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.rx.OnEqualsButtonPressedBusObserver
import com.globant.counter.rx.OnNumberButtonPressedBusObserver
import com.globant.counter.rx.OnOperationButtonPressedBusObserver
import com.globant.counter.utils.RxBus

class  CalculatorPresenter(private  val  model: CalculatorModel, private  val view: CalculatorView){

    init {
        val activity =view.activity;
        if (activity!=null){


            // Equals event
            RxBus.subscribe(activity, object : OnEqualsButtonPressedBusObserver() {
                override fun onEvent(value: OnEqualsButtonPressed) {
                    Log.v("Form Presenter","Numbre ${value.toString()} was pressed");
                    model.calculate();
                    view.setText("=");

                }
            })

            // Number Event
            RxBus.subscribe(activity,object  : OnNumberButtonPressedBusObserver(){
                override fun onEvent(value: OnNumberButtonPressed) {
                    view.setText(value.number.toString())
                }

            })

            // Operation Event
            RxBus.subscribe(activity,object : OnOperationButtonPressedBusObserver(){
                override fun onEvent(value: OnOperationButtonPressedBusObserver.OnOperationButtonPressed) {

                    view.setText(value.operation)
                }
            })

        }
    }

}