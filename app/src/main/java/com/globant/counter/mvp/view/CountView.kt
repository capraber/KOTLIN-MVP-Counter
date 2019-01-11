package com.globant.counter.mvp.view

import android.app.Activity
import com.globant.counter.rx.EventTypes.RESET_COUNT_EVENT
import com.globant.counter.rx.EventTypes.INCREMENT_EVENT
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.countBtn
import kotlinx.android.synthetic.main.activity_main.countLabel
import kotlinx.android.synthetic.main.activity_main.resetBtn

class CountView(activity: Activity) : ActivityView(activity) {

    val viewEventObservable: Observable<Int> = activity.countBtn
        .clicks()
        .map { INCREMENT_EVENT }
        .mergeWith(
            activity.resetBtn
            .clicks()
            .map { RESET_COUNT_EVENT }
        )

    fun setCount(count: String) {
        activity!!.countLabel.text = count
    }
}
