package com.globant.counter.mvp.model

import com.globant.counter.utils.Operation

class CalculateModel {

    var value1: String = ""
        private set

    var value2: String = ""
        private set

    var operatorSymbol: String = ""
        private set

    var result: String = ""
        private set

    var operation: Operation = Operation()

    fun clear() {
        value1 = ""
        value2 = ""
        operatorSymbol = ""
        result = ""
    }

    fun operate(): String{
        result = operation.operate(value1, operatorSymbol, value2)

        return result
    }

}
