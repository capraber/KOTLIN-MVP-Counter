package com.globant.counter.mvp.view


import android.app.Activity
import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.*
import com.globant.counter.utils.bus.observer.*
import kotlinx.android.synthetic.main.activity_main.*


class CalculatorView(activity: Activity) : ActivityView(activity) {

    init {
        activity.reset_button.setOnClickListener {
            RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        }

        activity.equal_button.setOnClickListener {
            RxBus.post(OnResultButtonPressedBusObserver.OnResultButtonPressed())
        }
        //Operations
        activity.add_button.setOnClickListener {
            RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Sum()))
        }

        activity.substract_button.setOnClickListener {
            RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Subtract()))
        }


        activity.multiply_button.setOnClickListener {
            RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Multiply()))
        }

        activity.divide_button.setOnClickListener {
            RxBus.post(OnOperatorButtonPressedBusObserver.OnOperatorButtonPressed(Divide()))
        }

        activity.square_button.setOnClickListener {
            RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(Square()))
        }

        activity.negate_button.setOnClickListener {
            RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(Negate()))
        }

        activity.pow2_button.setOnClickListener {
            RxBus.post(OnUnaryOperatorButtonPressedBusObserver.OnUnaryOperatorButtonPressed(PowerOf2()))
        }
        //Number listeners

        activity.one_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(1))
        }

        activity.two_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(2))
        }

        activity.three_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(3))
        }
        activity.four_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(4))
        }

        activity.five_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(5))
        }

        activity.six_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(6))
        }

        activity.seven_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(7))
        }

        activity.eight_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(8))
        }

        activity.nine_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(9))
        }

        activity.zero_button.setOnClickListener {
            RxBus.post(OnNumberButtonPressedBusObserver.OnNumberButtonPressed(0))
        }



    }

    fun setResult(count: String) {
        activity!!.count_label.text = count
    }
}
