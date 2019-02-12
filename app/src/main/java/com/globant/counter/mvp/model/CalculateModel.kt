package com.globant.counter.mvp.model

import android.util.Log
import com.globant.counter.utils.Operation
import com.globant.counter.utils.Operation.Companion.EMPTY_VALUE
import com.globant.counter.utils.Operation.Companion.UNDEFINED

class CalculateModel {

    var value1: String = EMPTY_VALUE

    var value2: String = EMPTY_VALUE

    var operatorSymbol: String = EMPTY_VALUE

    var result: String = EMPTY_VALUE
        private set

    var valueShowedInScreen: String = EMPTY_VALUE

    var operation: Operation = Operation()

    fun clear() {
        value1 = EMPTY_VALUE
        value2 = EMPTY_VALUE
        operatorSymbol = EMPTY_VALUE
        result = EMPTY_VALUE
        valueShowedInScreen = EMPTY_VALUE
    }

    fun addDigit(digit: String){
        if (operatorSymbol == EMPTY_VALUE && value2 == EMPTY_VALUE && result == EMPTY_VALUE) {
            value1 += digit

            valueShowedInScreen = value1
        }
        else if (operatorSymbol == EMPTY_VALUE && value2 == EMPTY_VALUE && (result != EMPTY_VALUE)) {
            value1 = EMPTY_VALUE
            value1 += digit

            result = EMPTY_VALUE

            valueShowedInScreen = value1
        }
        else if (value1 != EMPTY_VALUE && operatorSymbol != EMPTY_VALUE){
            value2 += digit

            valueShowedInScreen = value2
        }
    }

    fun setOperation(operatorSymbol: String) {
        this.operatorSymbol = operatorSymbol
        value2 = EMPTY_VALUE
    }

    fun operate() {
        if (canOperate()) {
            result = operation.operate(value1, operatorSymbol, value2)

            if (result == UNDEFINED) {
                value1 = EMPTY_VALUE
                value2 = EMPTY_VALUE
                operatorSymbol = EMPTY_VALUE
                result = EMPTY_VALUE
                valueShowedInScreen = UNDEFINED
            }
            else {
                value1 = result
                value2 = EMPTY_VALUE
                operatorSymbol = EMPTY_VALUE
                valueShowedInScreen = result
            }
        }
    }

    fun canOperate(): Boolean = (value1 != EMPTY_VALUE && operatorSymbol != EMPTY_VALUE && value2 != EMPTY_VALUE && result != UNDEFINED)
}