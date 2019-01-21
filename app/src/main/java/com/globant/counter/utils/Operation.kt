package com.globant.counter.utils

class AddOpertaion() : IOperation {
    override val operationSymbol: String
        get() = OpertaionSymbols.ADDITION.symbol

    override fun operate(value1: Double, value2: Double): Double {
        return  value1 + value2
    }
}

class SubstractOpertaion() : IOperation {
    override val operationSymbol: String
        get() = OpertaionSymbols.SUBSTRACTION.symbol
    override fun operate(value1: Double, value2: Double): Double {
        return  value1 - value2
    }
}

class MultipyOpertaion() : IOperation {
    override val operationSymbol: String
        get() =  OpertaionSymbols.MULTIPLICATION.symbol
    override fun operate(value1: Double, value2: Double): Double {
        return  value1 * value2
    }
}

class DivideOpertaion() : IOperation {
    override val operationSymbol: String
        get() = OpertaionSymbols.DIVISION.symbol
    override fun operate(value1: Double, value2: Double): Double {
        return  value1 / value2
    }
}