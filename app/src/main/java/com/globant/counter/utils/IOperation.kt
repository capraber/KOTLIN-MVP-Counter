package com.globant.counter.utils

interface IOperation{
    val operationSymbol: String

    fun operate(value1: Double, value2:Double) : Double?
}