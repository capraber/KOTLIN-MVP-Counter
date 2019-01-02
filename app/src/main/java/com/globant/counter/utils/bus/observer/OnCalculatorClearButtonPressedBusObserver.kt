package com.globant.counter.utils.bus.observer


import com.globant.counter.mvp.model.CalculatorITEM
import com.globant.counter.utils.bus.observer.BusObserver


abstract class OnCalculatorClearButtonPressedBusObserver : BusObserver<OnCalculatorClearButtonPressedBusObserver.OnCalculatorClearButton>
    (OnCalculatorClearButton::class.java) {

    class OnCalculatorClearButton
}