package com.weather.etu.presentation.today_fragment

import com.weather.etu.app.App
import com.weather.etu.base.BaseViewModel

class TodayFragmentViewModel: BaseViewModel() {
    init {
        App.component.inject(this)
    }
}