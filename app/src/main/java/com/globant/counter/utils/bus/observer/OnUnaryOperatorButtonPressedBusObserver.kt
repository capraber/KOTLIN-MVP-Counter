package com.globant.counter.utils.bus.observer

import com.globant.counter.utils.bus.UnaryOperator

abstract class OnUnaryOperatorButtonPressedBusObserver : BusObserver<OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed>
    (OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed::class.java) {

    class OnUnaryOperatorButtonPressed(val operator:UnaryOperator)
}
