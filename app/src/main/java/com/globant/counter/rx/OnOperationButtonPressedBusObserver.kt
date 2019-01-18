package com.globant.counter.rx

import com.globant.counter.utils.BusObserver


abstract  class OnOperationButtonPressedBusObserver : BusObserver<OnOperationButtonPressedBusObserver
.OnOperationButtonPressed>(OnOperationButtonPressedBusObserver.OnOperationButtonPressed::class.java){
    class OnOperationButtonPressed(val  operation: String)// TODO Think how to handle operation(class,string etc)
}