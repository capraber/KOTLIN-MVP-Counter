package com.globant.counter

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.globant.counter.mvvm.viewmodel.MainActivityViewModel
import com.globant.counter.mvvm.viewmodel.states.CounterData
import com.globant.counter.mvvm.viewmodel.states.CounterState
import kotlinx.android.synthetic.main.activity_main.countBtnDec
import kotlinx.android.synthetic.main.activity_main.countBtnInc
import kotlinx.android.synthetic.main.activity_main.countLabel
import kotlinx.android.synthetic.main.activity_main.resetBtn

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getValue().observe(this, Observer { updateUI(it) })
        initListeners()
    }

    private fun initListeners() {
        countBtnInc.setOnClickListener {
            viewModel.incValue()
        }
        countBtnDec.setOnClickListener {
            viewModel.decValue()
        }
        resetBtn.setOnClickListener {
            viewModel.resetValue()
        }
    }

    private fun updateUI(it: CounterData?) {
        when (it?.state) {
            CounterState.INITIAL -> countLabel.text = getString(R.string.txt_main_activity_starting_count_label_value)
            CounterState.INC -> {
                countLabel.text = it.value.toString()
                showToast(getString(R.string.main_activity_toast_incremented_text))
            }
            CounterState.DEC -> {
                countLabel.text = it.value.toString()
                showToast(getString(R.string.main_activity_toast_decremented_text))
            }
            else -> countLabel.text = it?.value.toString()
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
