package com.globant.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.mvp.model.CalculatorModel
import com.globant.counter.mvp.presenter.CalculatorPresenter
import com.globant.counter.mvp.view.CalculatorView
import com.globant.counter.utils.bus.RxBus


class MainActivity : AppCompatActivity() {

    private var presenter: CalculatorPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CalculatorPresenter(CalculatorModel(), CalculatorView(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.clear(this)
    }

}
