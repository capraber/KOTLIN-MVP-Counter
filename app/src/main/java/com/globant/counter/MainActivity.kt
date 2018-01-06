package com.globant.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.mvp.view.CountView
import com.globant.counter.utils.bus.RxBus


class MainActivity : AppCompatActivity() {

    private var presenter: CountPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CountPresenter(CountModel(), CountView(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.clear(this)
    }

}
