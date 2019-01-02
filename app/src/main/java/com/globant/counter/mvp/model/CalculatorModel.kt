package com.globant.counter.mvp.model

open class CalculatorModel {

    var action: CalculatorITEM = CalculatorITEM.EMPTY_ITEM
    var value1: Float = 0.0F
    var value2: Float = 0.0F

    fun setOperator(value: Float) {
        if (action == CalculatorITEM.EMPTY_ITEM) {
            value1 = value
        } else {
            value2 = value
        }
    }

    fun getExpression(): String {
        return "$value1 ${action.value}"
    }

    fun getResult(): String {
        try {
            return "${operate()}"
        } catch (e: IllegalStateException) {
            return "$value1"
        }
    }

    fun clear() {
        action = CalculatorITEM.EMPTY_ITEM
        value1 = 0.0F
        value2 = 0.0F
    }

    @Throws(IllegalStateException::class)
    private fun operate(): Float {
        if (action == CalculatorITEM.EMPTY_ITEM) {
            throw IllegalStateException()
        }

        value1 = when (action) {
            CalculatorITEM.DIVS -> (if (value2 != 0.0F) value1 / value2 else 0.0F)
            CalculatorITEM.MULTIP -> value1 * value2
            CalculatorITEM.RESTA -> value1 - value2
            CalculatorITEM.SUMA -> value1 + value2
            else -> 0.0F
        }
        value2 = 0.0F

        action = CalculatorITEM.EMPTY_ITEM
        return value1

    }

}