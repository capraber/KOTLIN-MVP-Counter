package com.globant.counter

import com.globant.counter.mvp.model.CalculateModel
import com.globant.counter.utils.Operation
import org.junit.Before
import org.junit.Test
import org.junit.Assert
import org.mockito.Mockito.`when` as whenever

class CalculateModelTest {

    private var model: CalculateModel? = null

    @Before
    fun setup() {
        model = CalculateModel()
    }

    @Test
    fun `When the plus button is entered as operator the result is an addition`() {
        val value1 = "23"
        val value2 = "15"

        model!!.value1 = value1
        model!!.operatorSymbol = Operation.ADD
        model!!.value2 = value2
        model!!.operate()

        Assert.assertEquals("38.0", model!!.result)
    }

    @Test
    fun `When the minus button is entered as operator the result is a substraction`() {
        val value1 = "30"
        val value2 = "12"

        model!!.value1 = value1
        model!!.operatorSymbol = Operation.SUBSTRACT
        model!!.value2 = value2
        model!!.operate()

        Assert.assertEquals("18.0", model!!.result)
    }

    @Test
    fun `When the times button is entered as operator the result is a multiplication`() {
        val value1 = "12"
        val value2 = "10"

        model!!.value1 = value1
        model!!.operatorSymbol = Operation.MULTIPLY
        model!!.value2 = value2
        model!!.operate()

        Assert.assertEquals("120.0", model!!.result)
    }

    @Test
    fun `When the divide button is entered as operator the result is a division`() {
        val value1 = "50"
        val value2 = "25"

        model!!.value1 = value1
        model!!.operatorSymbol = Operation.DIVIDE
        model!!.value2 = value2
        model!!.operate()

        Assert.assertEquals("2.0", model!!.result)
    }
}