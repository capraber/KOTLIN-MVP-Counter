package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.rx.EventTypes.ADDITION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.CLEAR_DISPLAY_EVENT
import com.globant.counter.rx.EventTypes.COMPLEMENT_VALUE_EVENT
import com.globant.counter.rx.EventTypes.DIVISION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.EIGHT_VALUE_EVENT
import com.globant.counter.rx.EventTypes.EQUALS_VALUE_EVENT
import com.globant.counter.rx.EventTypes.FIVE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.FOUR_VALUE_EVENT
import com.globant.counter.rx.EventTypes.MULTIPLICATION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.NINE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.ONE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.POWER_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SEVEN_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SIX_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SUBTRACTION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.THREE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.TWO_VALUE_EVENT
import com.globant.counter.rx.EventTypes.ZERO_VALUE_EVENT
import io.reactivex.disposables.CompositeDisposable

class CalculatorPresenter(private val model: CalculatorModel, val view: CalculatorView) {

    // If you are subscribing to events, always have a composite disposable to dispose of the observers and its references
    // when the presenter is not needed anymore
    private val compositeDisposable = CompositeDisposable()

    // method created to illustrate testing, not always is a good idea to have a standalone init method
    // we could have just the default kotlin init block
    fun initPresenter() {

        compositeDisposable.add(
            view.viewEventObservable.subscribe { clickEvent ->
                when (clickEvent) {
                    ZERO_VALUE_EVENT -> {
                        model.updateValueDisplayed("0")
                    }
                    ONE_VALUE_EVENT -> {
                        model.updateValueDisplayed( "1")
                    }
                    TWO_VALUE_EVENT -> {
                        model.updateValueDisplayed("2")
                    }
                    THREE_VALUE_EVENT -> {
                        model.updateValueDisplayed("3")
                    }
                    FOUR_VALUE_EVENT -> {
                        model.updateValueDisplayed("4")
                    }
                    FIVE_VALUE_EVENT -> {
                        model.updateValueDisplayed("5")
                    }
                    SIX_VALUE_EVENT -> {
                        model.updateValueDisplayed("6")
                    }
                    SEVEN_VALUE_EVENT -> {
                        model.updateValueDisplayed("7")
                    }
                    EIGHT_VALUE_EVENT -> {
                        model.updateValueDisplayed("8")
                    }
                    NINE_VALUE_EVENT -> {
                        model.updateValueDisplayed("9")
                    }
                    ADDITION_VALUE_EVENT -> {
                        model.updateValueDisplayed("+")
                    }
                    SUBTRACTION_VALUE_EVENT -> {
                        model.updateValueDisplayed("-")
                    }
                    MULTIPLICATION_VALUE_EVENT -> {
                        model.updateValueDisplayed("x")
                    }
                    DIVISION_VALUE_EVENT -> {
                        model.updateValueDisplayed("/")
                    }
                    COMPLEMENT_VALUE_EVENT -> {
                        model.updateValueDisplayed("~")
                    }
                    POWER_VALUE_EVENT -> {
                        model.updateValueDisplayed("^")
                    }
                    EQUALS_VALUE_EVENT -> {

                        if(model.verifyDataEntered()){
                            model.calculateOperation()
                        }else{
                            view.showToast()
                            model.clearValues()
                        }
                    }
                    CLEAR_DISPLAY_EVENT -> {
                        model.clearValues()

                    }
                }
                view.showDataEntered(model.valueDisplayed)

            }
        )
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }
}
