package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.view.CountView
import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.observer.OnCalculatorActionItemPressedBusObserver
import com.globant.counter.utils.bus.observer.OnCalculatorClearButtonPressedBusObserver
import com.globant.counter.utils.bus.observer.OnCalculatorEqualButtonPressedBusObserver
import com.globant.counter.utils.bus.observer.OnCalculatorNumberButtonPressedBusObserver

open class CountPresenter(model: CalculatorModel, view: CountView) {

    init {

        val activity = view.activity
        if (activity != null) {
            RxBus.subscribe(activity, object : OnCalculatorActionItemPressedBusObserver() {
                override fun onEvent(value: OnCalculatorActionButtonPressed) {
                    model.action = value.action
                    view.setExpression(model.getExpression())
                }
            })

            RxBus.subscribe(activity, object : OnCalculatorNumberButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorNumberButtonPressed) {
                    model.setOperator(value.number)
                    view.setExpression(model.getExpression())
                }
            })

            RxBus.subscribe(activity, object  : OnCalculatorEqualButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorEqualButtonPressed) {
                    view.setExpression(model.getResult())
                }
            })

            RxBus.subscribe(activity, object : OnCalculatorClearButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorClearButton) {
                    model.clear()
                    view.clear()
                }

            })

        }
    }

}
