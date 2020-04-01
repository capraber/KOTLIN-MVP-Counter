package com.globant.counter.mvvm.model

class CountModel {

    var count = 0
        private set

    fun reset() {
        count = 0
    }

    fun inc() {
        count += 1
    }

    fun dec() {
        count -= 1
    }

}
