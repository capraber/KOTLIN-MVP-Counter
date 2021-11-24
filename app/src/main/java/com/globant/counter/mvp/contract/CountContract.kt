package com.globant.counter.mvp.contract

interface CountContract {

    interface Model {
        fun getCount(): String
        fun reset()
        fun inc()
    }

    interface View {
        fun setCount(count: String)
        fun onCountButtonPressed(onClick: () -> Unit)
        fun onResetButtonPressed(onClick: () -> Unit)
    }

    interface Presenter {
        fun onCountButtonPressed()
        fun onResetButtonPressed()
    }
}
