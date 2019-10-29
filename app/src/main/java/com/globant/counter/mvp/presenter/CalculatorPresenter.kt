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
                        ZERO_VALUE_EVENT
                        , ONE_VALUE_EVENT
                        , TWO_VALUE_EVENT
                        , THREE_VALUE_EVENT
                        , FOUR_VALUE_EVENT
                        , FIVE_VALUE_EVENT
                        , SIX_VALUE_EVENT
                        , SEVEN_VALUE_EVENT
                        , EIGHT_VALUE_EVENT
                        , NINE_VALUE_EVENT -> {
                            updateNumberValue(clickEvent.toString())
                        }
                        ADDITION_VALUE_EVENT -> {
                            updateOperatorValue("+")
                        }
                        SUBTRACTION_VALUE_EVENT -> {
                            updateOperatorValue("-")
                        }
                        MULTIPLICATION_VALUE_EVENT -> {
                            updateOperatorValue("x")
                        }
                        DIVISION_VALUE_EVENT -> {
                            updateOperatorValue("/")
                        }
                        COMPLEMENT_VALUE_EVENT -> {
                            updateOperatorValue("~")

                        }
                        POWER_VALUE_EVENT -> {
                            updateOperatorValue("^")
                        }
                        EQUALS_VALUE_EVENT -> {
                            if(model.verifyDataEntered(model.valueDisplayed)){
                                model.obtainDigitsEntered(model.valueDisplayed)
                                model.calculateOperation(model.digit1,
                                        model.digit2, model.operator)
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

    private fun updateOperatorValue(value: String){
        if(model.valueDisplayed.length <= 9){
            model.updateValueDisplayed(value)
            model.saveOperator(value)
        }

    }

    private fun updateNumberValue(value :String){
        if(model.valueDisplayed.length <=9)
             model.updateValueDisplayed(value)
    }


}
