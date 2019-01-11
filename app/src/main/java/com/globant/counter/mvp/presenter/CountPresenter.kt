package com.globant.counter.mvp.presenter

import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.view.CountView
import com.globant.counter.rx.EventTypes.INCREMENT_EVENT
import com.globant.counter.rx.EventTypes.RESET_COUNT_EVENT
import io.reactivex.disposables.CompositeDisposable

class CountPresenter(private val model: CountModel, val view: CountView) {

    // If you are subscribing to events, always have a composite disposable to dispose of the observers and its references
    // when the presenter is not needed anymore
    private val compositeDisposable = CompositeDisposable()

    // method created to illustrate testing, not always is a good idea to have a standalone init method
    // we could have just the default kotlin init block
    fun initPresenter() {
        compositeDisposable.add(
            view.viewEventObservable.subscribe { clickEvent ->
                when (clickEvent) {
                    INCREMENT_EVENT -> {
                        model.inc()
                    }
                    RESET_COUNT_EVENT -> {
                        model.reset()
                    }
                }
                view.setCount(model.count.toString())
            }
        )
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }
}
