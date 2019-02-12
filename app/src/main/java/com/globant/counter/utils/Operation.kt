package com.globant.counter.utils

class Operation {

    companion object {
        public const val ADD = "+"
        public const val SUBSTRACT = "-"
        public const val MULTIPLY = "*"
        public const val DIVIDE = "/"
        public const val UNDEFINED = "Undefined"
        public const val EMPTY_VALUE = ""

        fun sum(value1: Double, value2: Double): Double = value1 + value2
        fun substract(value1: Double, value2: Double): Double = value1 - value2
        fun multiply(value1: Double, value2: Double): Double = value1 * value2
        fun divide(value1: Double, value2: Double): Double = value1 / value2
    }

    fun operate(value1: String, operatorSymbol: String, value2: String): String {
        when (operatorSymbol) {
            ADD -> return sum(value1.toDouble(), value2.toDouble()).toString()
            SUBSTRACT -> return substract(value1.toDouble(), value2.toDouble()).toString()
            MULTIPLY -> return multiply(value1.toDouble(), value2.toDouble()).toString()
            DIVIDE -> return if(value2 != "0") divide(value1.toDouble(), value2.toDouble()).toString() else UNDEFINED
            else -> return ""
        }
    }
}