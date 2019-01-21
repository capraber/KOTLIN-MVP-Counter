package com.globant.counter.rx

import com.globant.counter.utils.BusObserver

abstract  class OnDotButtonPressedBusObserver : BusObserver<OnDotButtonPressedBusObserver
.OnDotButtonPressed>(OnDotButtonPressedBusObserver.OnDotButtonPressed::class.java){
    class OnDotButtonPressed(val  dot: String)
}
