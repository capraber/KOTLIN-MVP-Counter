package com.globant.counter.mvp.model

import com.globant.counter.utils.bus.BinaryOperation
import com.globant.counter.utils.bus.UnaryOperator
import java.util.*

class CalculatorModel {

    var listOperands = Stack<Number>()
    var operation: BinaryOperation? = null


    fun reset() {
        listOperands.clear()
        operation = null
    }

    fun addOperand(number: Number) {
        if(listOperands.size == 0 || (listOperands.size == 1 &&  operation != null)) {
            listOperands.push(number)
        }
        else {
            val lastNumber = listOperands.pop()
            listOperands.push(((lastNumber.toDouble() * 10) + number.toDouble()))
        }
    }

    fun operate() {
        if (listOperands.size < 2) return
        if (operation != null) listOperands.push(operation!!.operate(listOperands.pop(),listOperands.pop()))
        operation = null
    }

    fun getLastOperator() : Double {
        return if (listOperands.isEmpty()) {
            0.0
        } else {
            listOperands.last().toDouble()
        }
    }

    fun unaryOperate(operator: UnaryOperator) {
        if(listOperands.size == 1) {
            val lastNumber = listOperands.pop()
            listOperands.push(operator!!.operate(lastNumber))
        }
    }

}
