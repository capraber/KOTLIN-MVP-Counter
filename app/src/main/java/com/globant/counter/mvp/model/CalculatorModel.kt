package com.globant.counter.mvp.model

class CalculatorModel {
    private var digitList = mutableListOf<Int>()

    var digit1 = 0.0;

    var digit2 = 0.0;

    var operator = ""

    var valueDisplayed = ""
        private set

    fun updateValueDisplayed(value: String) {
        valueDisplayed += value
    }

    fun clearValues() {
        valueDisplayed = ""
        operator = ""
        digit1 = 0.0
        digit2 = 0.0
        digitList.clear()
    }

    fun calculateOperation(d1: Double, d2: Double, operator: String) {
        var total  = 0.0
            when(operator) {
                "+" -> total = d1.plus(d2)
                "-" -> total = d1.minus(d2)
                "x" -> total = d1.times(d2)
                "^" -> total = Math.pow(d1, d2)
                "/" -> total = d1.div(d2)
                "~" -> total = d2.times(-1)
                else -> clearValues()
            }


        clearValues()
        valueDisplayed = total.toString()

    }


    fun verifyDataEntered(valueDisplayed: String):Boolean {
        val generalPattern = "[0-9]+[^0-9][0-9]+".toRegex()
        if(valueDisplayed.matches(generalPattern)){
            return true
        }
        return false
    }

    fun saveOperator(op: String) {
        operator = op
    }


    fun obtainDigitsEntered(valueDisplayed: String) {
        val pattern = "\\d+".toRegex()
        val found = pattern.findAll(valueDisplayed)
        found.forEach { f ->
            val d = f.value.toInt()
            digitList.add(d)
        }

        digit1 = digitList[digitList.size-2].toDouble()
        digit2 = digitList[digitList.size-1].toDouble()
    }

}
