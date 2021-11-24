package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.contract.CountContract

class CountPresenter(private val model: CountContract.Model, private val view: CountContract.View) : CountContract.Presenter {

    init {
        view.onCountButtonPressed { onCountButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }
    }

    override fun onCountButtonPressed() {
        model.inc()
        view.setCount(model.getCount())
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.getCount())
    }
}
