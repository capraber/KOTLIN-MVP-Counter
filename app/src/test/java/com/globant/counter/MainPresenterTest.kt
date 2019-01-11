package com.globant.counter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.presenter.CalculatorPresenter
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.utils.bus.*
import com.globant.counter.utils.bus.observer.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var presenter: CalculatorPresenter? = null
    private var model: CalculatorModel? = null
    @Mock
    lateinit var view: CalculatorView
    @Mock
    lateinit var activity: MainActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        model = CalculatorModel()
        // When
        whenever(view.activity).thenReturn(activity)
        presenter = CalculatorPresenter(model!!, view)
    }

    @Test
    fun isShouldSetNumberOne() {
        model!!.reset();
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))

        val count = "1.0"
        assertEquals(model!!.getLastOperator(), 1.0,0.0001)
        verify(view).setResult(count)
    }

    @Test
    fun isShouldDoBasicOperations() {
        model!!.reset()
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Sum()))
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(0))
        RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Subtract()))
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(0))
        RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Multiply()))
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Divide()))
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnResultButtonPressedBusObserver.OnResultButtonPressed())

        assertEquals(model!!.getLastOperator(), 1.0,0.0001)

        val invocations = 9
        verify(view, times(invocations)).setResult(anyString());
    }

    @Test
    fun isShouldDoUnaryOperations() {
        model!!.reset();
        val count = "1.0"
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(Negate()))
        RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(Negate()))
        RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(PowerOf2()))
        RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(Square()))

        assertEquals(model!!.getLastOperator(), 1.0,0.0001)

        val invocations = 5
        verify(view, times(invocations)).setResult(anyString());
    }

    @Test
    fun isShouldResetCalculator() {
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Sum()))
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(2))
        RxBus.post(OnResultButtonPressedBusObserver.OnResultButtonPressed())
        var count = 3.0
        assertEquals(model!!.getLastOperator(), count,0.0001)

        RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        count = 0.0
        assertEquals(model!!.getLastOperator(), 0.0,0.0001)
        val invocations = 4
        verify(view, times(invocations)).setResult(anyString());
    }
}