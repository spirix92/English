package com.selen.english.ui.fragment.wordsselect.di

import com.selen.english.ui.fragment.wordsselect.WordsSelectFragment
import dagger.Subcomponent

/**
 * @author Pyaterko Aleksey
 */
@Subcomponent(modules = [WordsSelectModule::class])
interface WordsSelectComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): WordsSelectComponent
    }

    fun inject(fragment: WordsSelectFragment)
}