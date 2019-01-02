package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.view.CountView
import com.globant.counter.utils.bus.RxBus

class CountPresenter(model: CalculatorModel, view: CountView) {

    init {

        val activity = view.activity
        if (activity != null) {

            RxBus.subscribe(activity, object : OnCountButtonPressedBusObserver() {
                override fun onEvent(value: OnCountButtonPressedBusObserver.OnCountButtonPressed) {
                    model.inc()
                    view.setCount(model.count.toString())
                }
            })

            RxBus.subscribe(activity, object : OnResetButtonPressedBusObserver() {
                override fun onEvent(value: OnResetButtonPressedBusObserver.OnResetButtonPressed) {
                    model.reset()
                    view.setCount(model.count.toString())
                }
            })
        }

    }
}
