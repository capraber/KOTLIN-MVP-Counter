package com.globant.counter.mvp.model

class CalculatorModel {
    private var digitList = mutableListOf<Int>()

    private var operatorsList = mutableListOf<String>()

    var valueDisplayed = ""
        private set

    fun updateValueDisplayed(value: String) {
        valueDisplayed += value
        val pattern = "\\d+".toRegex()
        if(!value.matches(pattern)){
            operatorsList.add(value)
        }
    }

    fun clearValues() {
        valueDisplayed = ""
        digitList.clear()
        operatorsList.clear()
    }

    fun calculateOperation() {
        var total  = 0.0
        val pattern = "\\d+".toRegex()
        val found = pattern.findAll(valueDisplayed)
       found.forEach { f ->
            val d= f.value.toInt()
            digitList.add(d)
        }

        if(digitList.size >= 2) {
            val d1 = (digitList[digitList.size-2]).toDouble()
            val d2 =  (digitList[digitList.size-1]).toDouble()
            val operator = operatorsList[operatorsList.size-1]
            when(operator) {
                "+" -> total = d1.plus(d2)
                "-" -> total = d1.minus(d2)
                "x" -> total = d1.times(d2)
                "^" -> total = Math.pow(d1, d2)
                "/" -> total = d1.div(d2)
                "~" -> total = d2.times(-1)
                else -> clearValues()
            }
        }

        clearValues()
        valueDisplayed = total.toString()

    }


    fun verifyDataEntered():Boolean {
        val generalPattern = "[0-9]+[^0-9][0-9]+".toRegex()
        if(valueDisplayed.matches(generalPattern)){
            return true
        }
        return false
    }

}
