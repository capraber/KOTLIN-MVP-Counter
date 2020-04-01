package com.globant.counter.mvvm.viewmodel.states

data class CounterData(
    val state: CounterState = CounterState.INITIAL,
    val value: Int = 0
)
