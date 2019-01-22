package com.globant.counter.utils

import org.junit.Test

import org.junit.Assert.*

class DivideOpertaionTest {

    @Test
    fun Operate() {
        var opertaion=DivideOpertaion()
        var actual: Double=opertaion.operate(10.0,2.0)
        assertEquals(5.0,actual,0.0001)
    }
}