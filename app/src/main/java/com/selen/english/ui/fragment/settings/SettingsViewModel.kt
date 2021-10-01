package com.selen.english.ui.fragment.settings

import com.selen.english.ui.base.BaseViewModel
import com.selen.english.ui.fragment.settings.interactor.SettingsInteractor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class SettingsViewModel @Inject constructor(private val settingsInteractor: SettingsInteractor) :
    BaseViewModel() {

    override fun onStart() {}

    fun reloadVerbs() {
        doWork {
            settingsInteractor.reloadVerbs()
        }
    }

    fun reloadWords() {
        doWork {
            settingsInteractor.reloadWords()
        }
    }
}