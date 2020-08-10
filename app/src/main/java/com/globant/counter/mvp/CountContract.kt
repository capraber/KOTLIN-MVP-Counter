package com.globant.counter.mvp

interface CountContract {
    interface Presenter{
        fun onCountButtonPressed()
        fun onResetButtonPressed()
    }

    interface Model{
        fun getCount(): String
        fun reset()
        fun inc()
    }

    interface View{
        fun setCount(count: String)
    }
}