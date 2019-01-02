package com.globant.counter.utils.bus.observer


import com.globant.counter.mvp.model.CalculatorITEM
import com.globant.counter.utils.bus.observer.BusObserver


abstract class OnCalculatorActionItemPressedBusObserver : BusObserver<OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed>
(OnCalculatorActionButtonPressed::class.java) {

    class OnCalculatorActionButtonPressed (var action: CalculatorITEM)
}