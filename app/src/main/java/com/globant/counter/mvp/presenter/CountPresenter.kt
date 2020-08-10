package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.CountContract
class CountPresenter(private val model: CountContract.Model, private val view: CountContract.View): CountContract.Presenter {

    override fun onCountButtonPressed() {
        model.inc()
        view.setCount(model.getCount())
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.getCount())
    }
}
