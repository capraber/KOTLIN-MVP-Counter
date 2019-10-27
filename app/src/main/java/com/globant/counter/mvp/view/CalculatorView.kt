package com.globant.counter.mvp.view

import android.app.Activity
import android.widget.Toast
import com.globant.counter.rx.EventTypes.ADDITION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.CLEAR_DISPLAY_EVENT
import com.globant.counter.rx.EventTypes.EIGHT_VALUE_EVENT
import com.globant.counter.rx.EventTypes.EQUALS_VALUE_EVENT
import com.globant.counter.rx.EventTypes.FIVE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.FOUR_VALUE_EVENT
import com.globant.counter.rx.EventTypes.RESET_COUNT_EVENT
import com.globant.counter.rx.EventTypes.INCREMENT_EVENT
import com.globant.counter.rx.EventTypes.NINE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.ONE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SEVEN_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SIX_VALUE_EVENT
import com.globant.counter.rx.EventTypes.SUBTRACTION_VALUE_EVENT
import com.globant.counter.rx.EventTypes.THREE_VALUE_EVENT
import com.globant.counter.rx.EventTypes.TWO_VALUE_EVENT
import com.globant.counter.rx.EventTypes.ZERO_VALUE_EVENT
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity) {

    val viewEventObservable: Observable<Int> = activity.countBtn
        .clicks()
        .map { INCREMENT_EVENT }
        .mergeWith(
            activity.resetBtn
            .clicks()
            .map { RESET_COUNT_EVENT }
        ).mergeWith(
            activity.addBtn
            .clicks()
            .map { ADDITION_VALUE_EVENT }
        ).mergeWith(
            activity.subBtn
            .clicks()
            .map { SUBTRACTION_VALUE_EVENT}
        ).mergeWith(
            activity.equalsBtn
            .clicks()
            .map { EQUALS_VALUE_EVENT}
        ).mergeWith(
            activity.clearBtn
            .clicks()
            .map { CLEAR_DISPLAY_EVENT}
        ).mergeWith(
            activity.zeroBtn
            .clicks()
            .map { ZERO_VALUE_EVENT }
        ).mergeWith(
            activity.oneBtn
            .clicks()
            .map { ONE_VALUE_EVENT}
        ).mergeWith(
            activity.twoBtn
            .clicks()
            .map { TWO_VALUE_EVENT}
        ).mergeWith(
            activity.threeBtn
            .clicks()
            .map { THREE_VALUE_EVENT}
        ).mergeWith(
            activity.fourBtn
            .clicks()
            .map { FOUR_VALUE_EVENT}
        ).mergeWith(
            activity.fiveBtn
            .clicks()
            .map { FIVE_VALUE_EVENT}
        ).mergeWith(
            activity.sixBtn
            .clicks()
            .map { SIX_VALUE_EVENT}
        ).mergeWith(
            activity.sevenBtn
            .clicks()
            .map { SEVEN_VALUE_EVENT}
        ).mergeWith(
            activity.eigthBtn
            .clicks()
            .map { EIGHT_VALUE_EVENT}
        ).mergeWith(
            activity.nineBtn
            .clicks()
            .map { NINE_VALUE_EVENT}
        )

    fun setCount(count: String) {
        activity!!.countLabel.text = count
    }

    fun showResult(result: String ){
        activity!!.displayLabel.text = result
    }

    fun showDataEntered(data :String){
        activity!!.displayLabel.text = data

    }

    fun showToast(){
        Toast.makeText(activity, "You must enter digit-symbol-digit ", Toast.LENGTH_SHORT).show()
    }
}
