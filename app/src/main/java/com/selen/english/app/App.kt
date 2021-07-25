package com.selen.english.app

import android.app.Application
import com.selen.english.di.AppComponent
import com.selen.english.di.DaggerAppComponent

/**
 * @author Pyaterko Aleksey
 */
class App : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}