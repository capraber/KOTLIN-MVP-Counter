package com.globant.counter

import com.globant.counter.mvp.model.CalculateModel
import com.globant.counter.mvp.presenter.CalculatePresenter
import com.globant.counter.mvp.view.CalculateView
import com.globant.counter.rx.EventTypes
import com.globant.counter.utils.Operation
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class CalculatePresenterTestTest {

    private var presenter: CalculatePresenter? = null
    @Mock
    lateinit var model: CalculateModel // Mocking the model is to illustrate a non-trivial model
    @Mock
    lateinit var view: CalculateView
    @Mock
    lateinit var activity: MainActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        // When
        whenever(view.activity).thenReturn(activity)

        presenter = CalculatePresenter(model, view)
    }

    @Test
    fun `When a number is pressed, the addDigit method is called with the number as argument`() {
        val value = "2"

        whenever(view.viewEventObservable).thenReturn(Observable.just(EventTypes.TWO_PRESSED_EVENT))
        presenter?.initPresenter()

        verify(model).addDigit(value)
    }

    @Test
    fun `When an operator is pressed, the setOperation method is called with the operator as argument`() {
        whenever(view.viewEventObservable).thenReturn(Observable.just(EventTypes.PLUS_PRESSED_EVENT))
        presenter?.initPresenter()

        verify(model).setOperation(Operation.ADD)
    }

    @Test
    fun `When the equal button is pressed the operate method is called`() {
        whenever(view.viewEventObservable).thenReturn(Observable.just(EventTypes.EQUAL_PRESSED_EVENT))
        presenter?.initPresenter()

        verify(model).operate()
    }

    @Test
    fun `When the clear button is pressed the clear method is called`() {
        whenever(view.viewEventObservable).thenReturn(Observable.just(EventTypes.CLEAR_PRESSED_EVENT))
        presenter?.initPresenter()

        verify(model).clear()
    }
}