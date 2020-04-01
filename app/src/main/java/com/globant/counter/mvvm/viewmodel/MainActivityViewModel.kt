package com.globant.counter.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.globant.counter.mvvm.model.CountModel
import com.globant.counter.mvvm.viewmodel.states.CounterData
import com.globant.counter.mvvm.viewmodel.states.CounterState

class MainActivityViewModel : ViewModel() {

    private val model = CountModel()

    private val mutableLiveData: MutableLiveData<CounterData> = MutableLiveData()

    fun getValue(): MutableLiveData<CounterData> {
        return mutableLiveData
    }

    fun resetValue() {
        model.reset()
        mutableLiveData.value = CounterData(CounterState.INITIAL)
    }

    fun incValue() {
        model.inc()
        mutableLiveData.value = CounterData(CounterState.INC, model.count)
    }

    fun decValue() {
        model.dec()
        mutableLiveData.value = CounterData(CounterState.DEC, model.count)
    }
}
