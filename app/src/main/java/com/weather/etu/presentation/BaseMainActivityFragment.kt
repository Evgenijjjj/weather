package com.weather.etu.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.weather.etu.base.BaseFragment

abstract class BaseMainActivityFragment: BaseFragment() {

    protected open val toolbar: Toolbar? = null

    protected val navViewModel by lazy { ViewModelProviders
        .of(activity as MainActivity)[MainActivityViewModel::class.java] }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).setSupportActionBar(toolbar?:return)
    }
}