package com.globant.counter.utils

class Operation {

    companion object {
        private const val ADD = "+"
        private const val SUBSTRACT = "-"
        private const val MULTIPLY = "*"
        private const val DIVIDE = "/"

        fun sum(value1: Double, value2: Double): Double = value1 + value2
        fun substract(value1: Double, value2: Double): Double = value1 - value2
        fun multiply(value1: Double, value2: Double): Double = value1 * value2
        fun divide(value1: Double, value2: Double): Double = value1 / value2
    }

    fun operate(value1: String, operatorSymbol: String, value2: String): String {
        val result = ""

        when (operatorSymbol) {
            ADD -> return sum(value1.toDouble(), value2.toDouble()).toString()
            SUBSTRACT -> return substract(value1.toDouble(), value2.toDouble()).toString()
            MULTIPLY -> return multiply(value1.toDouble(), value2.toDouble()).toString()
            DIVIDE -> return divide(value1.toDouble(), value2.toDouble()).toString()
            else -> return ""
        }

    }
}