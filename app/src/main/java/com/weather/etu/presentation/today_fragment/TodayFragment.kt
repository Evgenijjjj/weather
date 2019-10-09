package com.weather.etu.presentation.today_fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.weather.etu.R
import com.weather.etu.presentation.BaseMainActivityFragment
import kotlinx.android.synthetic.main.fragment_today.*


class TodayFragment: BaseMainActivityFragment<TodayFragmentViewModel>() {

    override val toolbar by lazy { f1_toolbar as Toolbar }

    override val viewModel by lazy { ViewModelProviders
        .of(this)[TodayFragmentViewModel::class.java] }

    override val layoutId: Int
        get() = R.layout.fragment_today

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchCurrentWeather()
    }
}