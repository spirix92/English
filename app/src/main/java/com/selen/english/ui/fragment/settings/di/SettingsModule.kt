package com.selen.english.ui.fragment.settings.di

import androidx.lifecycle.ViewModel
import com.selen.english.di.ViewModelKey
import com.selen.english.ui.fragment.settings.SettingsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Pyaterko Aleksey
 */
@Module
abstract class SettingsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindViewModel(viewmodel: SettingsViewModel): ViewModel
}