package com.globant.counter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.mvp.view.CountView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CountPresenter(CountModel(), CountView(this))
    }
}
