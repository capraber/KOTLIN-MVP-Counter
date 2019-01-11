package com.globant.counter.utils.bus

import kotlin.math.pow

class Sum: BinaryOperation() {
    override fun operate(number1: Number, number2: Number): Double {
        return number1.toDouble() + number2.toDouble()
    }
}

class Subtract: BinaryOperation() {
    override fun operate(number1: Number, number2: Number): Double {
        return number2.toDouble() - number1.toDouble()
    }
}

class Multiply: BinaryOperation() {
    override fun operate(number1: Number, number2: Number): Double {
        return number1.toDouble() * number2.toDouble()
    }
}

class Divide: BinaryOperation() {
    override fun operate(number1: Number, number2: Number): Double {
        return number2.toDouble() / number1.toDouble()
    }
}

class Square: UnaryOperator() {
    override fun operate(number: Number): Double {
        return Math.sqrt(number.toDouble())
    }
}

class Negate: UnaryOperator() {
    override fun operate(number: Number): Double {
        return number.toDouble() * (-1)
    }
}

class PowerOf2: UnaryOperator() {
    override fun operate(number: Number): Double {
        return number.toDouble().pow(2)
    }
}