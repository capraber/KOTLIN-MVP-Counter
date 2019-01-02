package com.globant.counter


import com.globant.counter.mvp.model.CalculatorITEM
import com.globant.counter.mvp.model.CalculatorModel
import org.junit.After
import org.junit.Assert
import org.junit.Test

class ModelUnitTest {

    private val model : CalculatorModel = CalculatorModel()

    @Test
    fun getSumaTest() {
        model.setOperator(5.0f)
        model.action = CalculatorITEM.SUMA
        model.setOperator(3.0f)

        Assert.assertEquals(model.getResult(), "8.0")
        Assert.assertEquals(model.getExpression(), "8.0 ")
    }

    @Test
    fun getRestTest() {
        model.setOperator(12.0f)
        model.action = CalculatorITEM.RESTA
        model.setOperator(2.0f)

        Assert.assertEquals(model.getResult(), "10.0")
        Assert.assertEquals(model.getExpression(), "10.0 ")
    }

    @Test
    fun getMultTest() {
        model.setOperator(2.0f)
        model.action = CalculatorITEM.MULTIP
        model.setOperator(2.0f)

        Assert.assertEquals(model.getResult(), "4.0")
        Assert.assertEquals(model.getExpression(), "4.0 ")
    }

    @Test
    fun getDivTest() {
        model.setOperator(10.0f)
        model.action = CalculatorITEM.DIVS
        model.setOperator(2.0f)

        Assert.assertEquals(model.getResult(), "5.0")
        Assert.assertEquals(model.getExpression(), "5.0 ")
    }


}