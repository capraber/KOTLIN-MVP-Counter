package com.globant.counter.utils

import org.junit.Test

import org.junit.Assert.*

class MultipyOpertaionTest {

    @Test
    fun Operate() {
        var opertaion=MultipyOpertaion()
        var actual: Double=opertaion.operate(2.0,2.0)
        assertEquals(4.0,actual,0.0001)
    }
}