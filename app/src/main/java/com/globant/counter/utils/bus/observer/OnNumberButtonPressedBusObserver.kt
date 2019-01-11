package com.globant.counter.utils.bus.observer

abstract class OnNumberButtonPressedBusObserver : BusObserver<OnNumberButtonPressedBusObserver.OnNumberButtonPressed>
    (OnNumberButtonPressedBusObserver.OnNumberButtonPressed::class.java) {

    class OnNumberButtonPressed(val number: Number)
}
