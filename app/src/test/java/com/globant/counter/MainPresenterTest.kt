package com.globant.counter

import com.globant.counter.mvp.CountContract
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.util.Constants.ONE
import com.globant.counter.util.Constants.ZERO
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test


class PresenterTest {

    private lateinit var presenter: CountContract.Presenter
    private val model: CountContract.Model = mock()
    private val view: CountContract.View = mock()

    @Before
    fun setup() {
        presenter = CountPresenter(model, view)
    }

    @Test
    fun `on inc button pressed, the value increments one to the count`() {
        val count = ONE.toString()
        whenever(model.getCount()).thenReturn(count)

        presenter.onCountButtonPressed()

        verify(model).inc()
        verify(model).getCount()
        verify(view).setCount(count)
    }

    @Test
    fun `on reset button pressed, the count value is reset to zero` () {
        val countResetValue = ZERO.toString()
        whenever(model.getCount()).thenReturn(countResetValue)

        presenter.onResetButtonPressed()

        verify(model).reset()
        verify(model).getCount()
        verify(view).setCount(countResetValue)
    }
}