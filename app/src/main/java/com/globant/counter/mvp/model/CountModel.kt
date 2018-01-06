package com.globant.counter.mvp.model

class CountModel {

    var count = 0
        private set

    fun reset() {
        count = 0
    }

    fun inc() {
        count += 1
    }

}
