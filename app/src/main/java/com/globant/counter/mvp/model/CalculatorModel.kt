package com.globant.counter.mvp.model

import android.util.Log
import com.globant.counter.utils.IOperation
import com.globant.counter.utils.OpertaionSymbols

class  CalculatorModel{

    var firstValue: String = ""

    var secondValue: String = ""
    var operation: IOperation? = null
    var result: Double? = 0.0

    var operationSelected: Boolean = false



    fun setfirstValue(value: String){
        firstValue=value
    }
    fun reset(){
        firstValue= OpertaionSymbols.EMPTY.toString()
        secondValue=OpertaionSymbols.EMPTY.toString()
        operation=null
    }



    fun calculate(): String{
        result= operation?.operate(firstValue.toDouble(),secondValue.toDouble())

        return result.toString()
    }


}