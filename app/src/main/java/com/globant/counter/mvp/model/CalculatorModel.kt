package com.globant.counter.mvp.model

import android.util.Log
import com.globant.counter.utils.IOperation

class  CalculatorModel{

    var firstValue: Double = 0.0
    var secondValue: Double = 0.0
    var operation: IOperation? = null

    var operationSelected: Boolean = false

    fun addValue(number: Number){
        if(operation==null){
            firstValue=number.toDouble()

        }

    }

    fun reset(){
        firstValue=0.0
        secondValue=0.0
        operation=null
    }



    fun calculate(){

        Log.v("Equals calculation","Equals was correctly pressed")
        operation?.operate(firstValue, secondValue)
    }


}