package com.weather.etu.presentation.chart_fragment

import androidx.lifecycle.ViewModelProviders
import com.weather.etu.R
import com.weather.etu.presentation.BaseMainActivityFragment

class ChartFragment: BaseMainActivityFragment() {

    private val viewModel by lazy { ViewModelProviders
        .of(this)[ChartFragmentViewModel::class.java] }

    override val layoutId: Int
        get() = R.layout.fragment_chart
}