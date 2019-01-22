package com.globant.counter.utils

import org.junit.Test

import org.junit.Assert.*

class SubstractOpertaionTest {

    @Test
    fun Operate() {
        var opertaion=SubstractOpertaion()
        var actual: Double=opertaion.operate(2.0,2.0)
        assertEquals(0.0,actual,0.0001)
    }

}