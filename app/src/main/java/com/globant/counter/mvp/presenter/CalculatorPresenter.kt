package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.observer.*

class CalculatorPresenter(val model: CalculatorModel, val view: CalculatorView) {

    init {

        val activity = view.activity
        if (activity != null) {
            RxBus.subscribe(activity, object : OnResetButtonPressedBusObserver() {
                override fun onEvent(value: OnResetButtonPressedBusObserver.OnResetButtonPressed) {
                    model.reset()
                    view.setResult("0.0")
                }
            })

            //Number
            RxBus.subscribe(activity, object : OnNumberButtonPressedBusObserver() {
                override fun onEvent(value: OnNumberButtonPressedBusObserver.OnNumberButtonPressed) {
                    model.addOperand(value.number)
                    view.setResult(model.getLastOperator().toString())
                }
            })

            //Operator
            RxBus.subscribe(activity, object : OnOperatorButtonPressedBusObserver() {
                override fun onEvent(value: OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed) {
                    if (model.operation != null) operateResult()
                    model.operation = value.operation
                }
            })

            //Operate, Result
            RxBus.subscribe(activity, object : OnResultButtonPressedBusObserver() {
                override fun onEvent(value: OnResultButtonPressedBusObserver.OnResultButtonPressed) {
                    operateResult()
                }
            })

            //Unary Operator
            RxBus.subscribe(activity, object : OnUnaryOperatorButtonPressedBusObserver() {
                override fun onEvent(value: OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed) {
                    model.unaryOperate(value.operator)
                    view.setResult(model.getLastOperator().toString())
                }
            })
        }
    }

    fun operateResult(){
        model.operate()
        view.setResult(model.getLastOperator().toString())
    }


}
