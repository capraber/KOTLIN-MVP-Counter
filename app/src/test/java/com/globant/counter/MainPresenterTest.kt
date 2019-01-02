package com.globant.counter

import com.globant.counter.mvp.model.CalculatorITEM
import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.mvp.view.CountView
import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.observer.OnCalculatorActionItemPressedBusObserver
import com.globant.counter.utils.bus.observer.OnCalculatorEqualButtonPressedBusObserver
import com.globant.counter.utils.bus.observer.OnCalculatorNumberButtonPressedBusObserver
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var presenter: CountPresenter? = null
    private var model: CalculatorModel? = null
    @Mock
    lateinit var view: CountView
    @Mock
    lateinit var activity: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        model = CalculatorModel()

        // When
        whenever(view.activity).thenReturn(activity)

        presenter = CountPresenter(model!!, view)
    }

    @Test

    fun sumaTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(7.0f))
        RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.SUMA))
        verify(view, times(1)).setExpression("7.0 +")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))

        assertEquals(model?.action, CalculatorITEM.SUMA)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())

        assertEquals(model?.value1, 12.0f)
        assertEquals(model?.value2, 0.0f)

    }

    @Test
    fun restaTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(10.0f))
        RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.RESTA))
        verify(view, times(1)).setExpression("10.0 -")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(3.0f))

        assertEquals(model?.action,CalculatorITEM.RESTA)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())


        assertEquals(model?.value1, 7.0f)
        assertEquals(model?.value2, 0.0f)
    }

    @Test
    fun multiOperationTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(7.0f))
        RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.MULTIP))
        verify(view, times(1)).setExpression("7.0 *")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(4.0f))

        assertEquals(model?.action, CalculatorITEM.MULTIP)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())


        assertEquals(model?.value1, 28.0f)
        assertEquals(model?.value2, 0.0f)
    }

    @Test
    fun divOperationTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(25.0f))
        RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.DIVS))
        verify(view, times(1)).setExpression("25.0 /")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))

        assertEquals(model?.action, CalculatorITEM.DIVS)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())


        assertEquals(model?.value1, 5.0f)
        assertEquals(model?.value2, 0.0f)
    }


}