package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.model.CalculateModel
import com.globant.counter.mvp.view.CalculateView
import com.globant.counter.rx.EventTypes.PLUS_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.MINUS_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.TIMES_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.DIVIDE_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.EQUAL_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.CLEAR_PRESSED_EVENT
import com.globant.counter.utils.Operation
import io.reactivex.disposables.CompositeDisposable

class CalculatePresenter(private val model: CalculateModel, val view: CalculateView) {

    // If you are subscribing to events, always have a composite disposable to dispose of the observers and its references
    // when the presenter is not needed anymore
    private val compositeDisposable = CompositeDisposable()

    // method created to illustrate testing, not always is a good idea to have a standalone init method
    // we could have just the default kotlin init block
    fun initPresenter() {
        compositeDisposable.add(
            view.viewEventObservable.subscribe { clickEvent ->
                if (clickEvent < 10){
                    model.addDigit(clickEvent.toString())
                }
                else {
                    when (clickEvent) {
                        PLUS_PRESSED_EVENT -> {
                            model.setOperation(Operation.ADD)
                        }
                        MINUS_PRESSED_EVENT -> {
                            model.setOperation(Operation.SUBSTRACT)
                        }
                        TIMES_PRESSED_EVENT -> {
                            model.setOperation(Operation.MULTIPLY)
                        }
                        DIVIDE_PRESSED_EVENT -> {
                            model.setOperation(Operation.DIVIDE)
                        }
                        EQUAL_PRESSED_EVENT -> {
                            model.operate()
                        }
                        CLEAR_PRESSED_EVENT -> {
                            model.clear()
                        }
                    }
                }
                view.setValue(model.valueShowedInScreen)
            }
        )
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }
}
