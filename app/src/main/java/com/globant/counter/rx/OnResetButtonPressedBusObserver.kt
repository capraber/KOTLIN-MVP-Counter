package com.globant.counter.rx

import com.globant.counter.utils.BusObserver

abstract class OnResetButtonPressedBusObserver : BusObserver<OnResetButtonPressedBusObserver.OnResetButtonPressed>
(OnResetButtonPressedBusObserver.OnResetButtonPressed::class.java){

    class OnResetButtonPressed
}