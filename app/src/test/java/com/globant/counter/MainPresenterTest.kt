package com.globant.counter

import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.presenter.CalculatorPresenter
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.rx.*
import com.globant.counter.utils.AddOpertaion
import com.globant.counter.utils.OpertaionSymbols
import com.globant.counter.utils.RxBus
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.junit.Assert.assertEquals
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var mPresenter: CalculatorPresenter? = null
    private var mModel: CalculatorModel? = null
    @Mock
    lateinit var mView: CalculatorView
    @Mock
    lateinit var mActivity: MainActivity

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        mModel= CalculatorModel()
        whenever(mView.activity).thenReturn(mActivity)
        mPresenter = CalculatorPresenter(mModel!!, mView)

    }

    @Test
    fun calculatorPresenterResetModelTest() {


        assertEquals("", mModel!!.firstValue)
        assertEquals("", mModel!!.secondValue)

        RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())

        assertEquals(OpertaionSymbols.EMPTY.toString(), mModel!!.firstValue)
        assertEquals(OpertaionSymbols.EMPTY.toString(), mModel!!.secondValue)
        verify(mView).resetText()

    }

    @Test
    fun ShouldDisplayNumberWhenButtonPressed() {

        val testNumberPressed="1"
        whenever(mView.getText()).thenReturn(testNumberPressed)

        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))

        verify(mView).appendText("1")
        assertEquals("1", mView.getText())

    }

    @Test
    fun ShouldAddTest() {

        //whenever(mView.setText("2")).then()
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(AddOpertaion()))
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        RxBus.post(OnEqualsButtonPressedBusObserver.OnEqualsButtonPressed())

        assertEquals("2", mModel!!.result)
        verify(mView).setText("2")
    }


}