package com.globant.counter.utils

import org.junit.Test

import org.junit.Assert.*

class AddOpertaionTest {

    @Test
    fun getOperationSymbol() {
    }

    @Test
    fun addOperation() {
        var addOpertaion=AddOpertaion()
        var actual: Double=addOpertaion.operate(2.0,2.0)
        assertEquals(4.0,actual,0.0001)
    }

}