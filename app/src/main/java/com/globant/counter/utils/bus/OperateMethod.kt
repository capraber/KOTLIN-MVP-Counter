package com.globant.counter.utils.bus


abstract class Operation

abstract class BinaryOperation : Operation() {
    abstract fun operate(number1: Number, number2: Number) : Double
}

abstract class UnaryOperator : Operation(){
    abstract fun operate(number1: Number): Double
}