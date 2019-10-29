package com.globant.counter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.presenter.CalculatorPresenter
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.rx.EventTypes.ADDITION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.CLEAR_DISPLAY_EVENT
import com.globant.counter.rx.EventTypes.EQUALS_VALUE_EVENT
import com.globant.counter.rx.EventTypes.FIVE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SUBTRACTION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.THREE_VALUE_EVENT
//import com.globant.counter.rx.EventTypes.RESET_COUNT_EVENT
import io.reactivex.Observable
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var presenter: CalculatorPresenter? = null
    @Mock
    lateinit var model: CalculatorModel // Mocking the model is to illustrate a non-trivial model
    @Mock
    lateinit var view: CalculatorView
    @Mock
    lateinit var activity: MainActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        // When
        whenever(view.activity).thenReturn(activity)

        presenter = CalculatorPresenter(model, view)
    }


    @Test
    fun presenterResetValuesTest() {
        val d1 = 0.0
        val d2 = 0.0
        val valueDisplayed = ""
        whenever(model.valueDisplayed).thenReturn(valueDisplayed)
        whenever(model.digit1).thenReturn(d1)
        whenever(model.digit2).thenReturn(d2)
        whenever(view.viewEventObservable).thenReturn(Observable.just(CLEAR_DISPLAY_EVENT))
        presenter?.initPresenter()
        verify(model).clearValues()
        verify(view).showDataEntered(valueDisplayed)
    }



    @Test
    fun isShouldDisplayData(){
        val valueDisplayed = 35
        val lastValueEntered = 5
        whenever(model.valueDisplayed).thenReturn(valueDisplayed.toString())
        whenever(view.viewEventObservable).thenReturn(Observable.just(THREE_VALUE_EVENT))
        whenever(view.viewEventObservable).thenReturn(Observable.just(FIVE_VALUE_EVENT))
        presenter?.initPresenter()
        verify(model).updateValueDisplayed(lastValueEntered.toString())
        verify(view).showDataEntered(valueDisplayed.toString())
        verify (model).valueDisplayed
    }

    @Test
    fun presenterValueWithSumOperatorTest(){
        val valueDisplayed = "3+5"
        whenever(model.valueDisplayed).thenReturn(valueDisplayed)
        whenever(view.viewEventObservable).thenReturn(Observable.just(THREE_VALUE_EVENT))
        whenever(view.viewEventObservable).thenReturn(Observable.just(ADDITION_VALUE_EVENT))
        whenever(view.viewEventObservable).thenReturn(Observable.just(FIVE_VALUE_EVENT))
        presenter?.initPresenter()
        verify(view).showDataEntered(valueDisplayed)
    }

    @Test
    fun presenterVerifyDataEnteredTrueTest(){
        val data = "3+5"
        whenever(model.verifyDataEntered(data)).thenReturn(true)
        whenever(model.valueDisplayed).thenReturn(data)
        whenever(view.viewEventObservable).thenReturn(Observable.just(THREE_VALUE_EVENT))
        whenever(view.viewEventObservable).thenReturn(Observable.just(ADDITION_VALUE_EVENT))
        whenever(view.viewEventObservable).thenReturn(Observable.just(FIVE_VALUE_EVENT))
        whenever(view.viewEventObservable).thenReturn(Observable.just(EQUALS_VALUE_EVENT))
        presenter?.initPresenter()
        verify(model).verifyDataEntered(data)
    }

    @Test
    fun presenterVerifyDataEnteredFalseTest(){
        val data = "3+-5"
        whenever(model.verifyDataEntered(data)).thenReturn(false)
        whenever(model.valueDisplayed).thenReturn(data)
        whenever(view.viewEventObservable).thenReturn(Observable.just(EQUALS_VALUE_EVENT))
        presenter?.initPresenter()
        verify(model).verifyDataEntered(data)
    }

    @Test
    fun calculateOperationTest(){
        val dataTyped = "10+100"
        whenever(model.verifyDataEntered(dataTyped)).thenReturn(true)
        whenever(model.valueDisplayed).thenReturn(dataTyped)
        whenever(model.digit1).thenReturn(10.0)
        whenever(model.digit2).thenReturn(100.0)
        whenever(model.operator).thenReturn("+")
        whenever(view.viewEventObservable).thenReturn(Observable.just(EQUALS_VALUE_EVENT))
        presenter?.initPresenter()
        verify(model).calculateOperation(model.digit1, model.digit2, model.operator)
        Assert.assertEquals(model.digit1, 10.0)
        Assert.assertEquals(model.digit2, 100.0)
        Assert.assertEquals(model.operator, "+")


    }
}