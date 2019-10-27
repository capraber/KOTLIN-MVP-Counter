package com.globant.counter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.presenter.CalculatorPresenter
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.rx.EventTypes
import com.globant.counter.rx.EventTypes.RESET_COUNT_EVENT
import io.reactivex.Observable
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
    fun isShouldIncCountByOne() {
        val count = 1
        whenever(model.count).thenReturn(count)
        whenever(view.viewEventObservable).thenReturn(Observable.just(EventTypes.INCREMENT_EVENT))
        presenter?.initPresenter()

        verify(model).inc()
        verify(model).count
        verify(view).setCount(count.toString())
    }

    @Test
    fun presenterResetModelTest() {
        val countResetValue = 0
        whenever(model.count).thenReturn(countResetValue)
        whenever(view.viewEventObservable).thenReturn(Observable.just(RESET_COUNT_EVENT))

        presenter?.initPresenter()
        verify(model).reset()
        verify(model).count
        verify(view).setCount(countResetValue.toString())
    }
}