package com.globant.counter.mvp.model

import com.globant.counter.mvp.CountContract
import com.globant.counter.util.Constants.ONE
import com.globant.counter.util.Constants.ZERO

class CountModel: CountContract.Model {

    private var count = ZERO

    override fun getCount(): String = count.toString()

    override fun reset() {
        count = ZERO
    }

    override fun inc() {
        count += ONE
    }

}
