package com.globant.counter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globant.counter.databinding.ActivityMainBinding
import com.globant.counter.mvp.CountContract
import com.globant.counter.mvp.model.CountModel
import com.globant.counter.mvp.presenter.CountPresenter
import com.globant.counter.mvp.view.CountView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: CountContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = CountPresenter(CountModel(), CountView(this))
        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        binding.countBtn.setOnClickListener {
            presenter.onCountButtonPressed()
        }
        binding.resetBtn.setOnClickListener {
            presenter.onResetButtonPressed()
        }
    }
}
