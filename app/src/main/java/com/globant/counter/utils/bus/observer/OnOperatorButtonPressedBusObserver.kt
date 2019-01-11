package com.globant.counter.utils.bus.observer

import com.globant.counter.utils.bus.BinaryOperation

abstract class OnOperatorButtonPressedBusObserver : BusObserver<OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed>
    (OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed::class.java) {

    class OnOperatorButtonPressed(val operation: BinaryOperation)
}
