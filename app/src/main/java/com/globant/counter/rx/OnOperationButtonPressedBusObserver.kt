package com.globant.counter.rx

import com.globant.counter.utils.BusObserver
import com.globant.counter.utils.IOperation


abstract  class OnOperationButtonPressedBusObserver : BusObserver<OnOperationButtonPressedBusObserver
.OnOperationButtonPressed>(OnOperationButtonPressedBusObserver.OnOperationButtonPressed::class.java){
    class OnOperationButtonPressed(val  operation: IOperation)
}