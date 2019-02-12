package com.globant.counter.mvp.view

import android.app.Activity
import android.view.View
import com.globant.counter.rx.EventTypes.ZERO_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.ONE_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.TWO_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.THREE_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.FOUR_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.FIVE_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.SIX_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.SEVEN_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.EIGHT_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.NINE_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.PLUS_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.MINUS_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.TIMES_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.DIVIDE_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.EQUAL_PRESSED_EVENT
import com.globant.counter.rx.EventTypes.CLEAR_PRESSED_EVENT
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class CalculateView(activity: Activity) : ActivityView(activity) {

    companion object {
        private var valuePressed = ""
    }

    val viewEventObservable: Observable<Int> = activity.zeroBtn
            .clicks()
            .map { ZERO_PRESSED_EVENT }
            .mergeWith(
                    activity.oneBtn
                            .clicks()
                            .map { ONE_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.twoBtn
                            .clicks()
                            .map { TWO_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.threeBtn
                            .clicks()
                            .map { THREE_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.fourBtn
                            .clicks()
                            .map { FOUR_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.fiveBtn
                            .clicks()
                            .map { FIVE_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.sixBtn
                            .clicks()
                            .map { SIX_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.sevenBtn
                            .clicks()
                            .map { SEVEN_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.eightBtn
                            .clicks()
                            .map { EIGHT_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.nineBtn
                            .clicks()
                            .map { NINE_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.plusBtn
                            .clicks()
                            .map { PLUS_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.minusBtn
                            .clicks()
                            .map { MINUS_PRESSED_EVENT }
            )
            .mergeWith(
                    activity.timesBtn
                            .clicks()
                            .map { TIMES_PRESSED_EVENT }
            ).mergeWith(
                    activity.divideBtn
                            .clicks()
                            .map { DIVIDE_PRESSED_EVENT }
            ).mergeWith(
                    activity.clearBtn
                            .clicks()
                            .map { CLEAR_PRESSED_EVENT }
            ).mergeWith(
                    activity.equalBtn
                            .clicks()
                            .map { EQUAL_PRESSED_EVENT }
            )

    fun setValue(count: String) {
        activity!!.countLabel.text = count
    }
}
