package com.globant.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.mvp.view.CountView

class MainActivity : AppCompatActivity() {

    private var presenter: CountPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CountPresenter(CountModel(), CountView(this))
    }

    override fun onResume() {
        super.onResume()
        presenter?.initPresenter()
    }

    override fun onDestroy() {
        presenter?.disposeObservers()
        // Call on destroy after doing what you have to do with the presenter because it may cause unwanted exceptions
        // in the view
        super.onDestroy()
    }
}
