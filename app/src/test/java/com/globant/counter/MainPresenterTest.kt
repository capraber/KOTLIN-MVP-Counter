package com.globant.counter

import android.test.MoreAsserts.assertEquals
import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.presenter.CalculatorPresenter
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.mvp.view.CountView
import com.globant.counter.rx.EventTypes
import com.globant.counter.rx.EventTypes.RESET_COUNT_EVENT
import com.globant.counter.rx.OnNumberButtonPressedBusObserver
import com.globant.counter.rx.OnOperationButtonPressedBusObserver
import com.globant.counter.utils.AddOpertaion
import com.globant.counter.utils.RxBus
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.junit.Assert.assertEquals
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var presenter: CountPresenter? = null
    @Mock
    lateinit var model: CountModel // Mocking the model is to illustrate a non-trivial model
    @Mock
    lateinit var view: CountView
    @Mock
    lateinit var activity: MainActivity


    private var mPresenter: CalculatorPresenter? = null
    @Mock
    lateinit var mModel: CalculatorModel // Mocking the model is to illustrate a non-trivial model
    @Mock
    lateinit var mView: CalculatorView
    @Mock
    lateinit var mActivity: MainActivity



    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)
        // When
        whenever(mView.activity).thenReturn(mActivity)

        mPresenter = CalculatorPresenter(mModel, mView)
    }



    @Test
    fun isShouldSetFirstValue() {

        // mModel.reset()
        RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(8))
        // RxBus.post(OnOperationButtonPressedBusObserver.OnOperationButtonPressed(AddOpertaion()))

        // mModel.setfirstValue("8")
        assertEquals("8", mModel.firstValue)
        verify(mView).setText("8")
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