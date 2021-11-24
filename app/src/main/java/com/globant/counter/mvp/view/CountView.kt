package com.globant.counter.mvp.view

import android.app.Activity
import com.globant.counter.databinding.ActivityMainBinding
import com.globant.counter.mvp.contract.CountContract
import com.globant.counter.mvp.view.base.ActivityView

class CountView(activity: Activity) : ActivityView(activity), CountContract.View {

    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    override fun setCount(count: String) {
        binding.countLabel.text = count
    }

    override fun onCountButtonPressed(onClick: () -> Unit) {
        binding.countBtn.setOnClickListener { onClick() }
    }

    override fun onResetButtonPressed(onClick: () -> Unit) {
        binding.resetBtn.setOnClickListener { onClick() }
    }
}
