package com.selen.english.ui.fragment.settings.di

import com.selen.english.ui.fragment.settings.SettingsFragment
import dagger.Subcomponent

/**
 * @author Pyaterko Aleksey
 */
@Subcomponent(modules = [SettingsModule::class])
interface SettingsComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsComponent
    }

    fun inject(fragment: SettingsFragment)
}