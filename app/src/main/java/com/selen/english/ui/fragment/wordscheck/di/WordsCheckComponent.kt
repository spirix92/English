package com.selen.english.ui.fragment.wordscheck.di

import com.selen.english.ui.fragment.wordscheck.WordsCheckFragment
import dagger.Subcomponent

/**
 * @author Pyaterko Aleksey
 */
@Subcomponent(modules = [WordsCheckModule::class])
interface WordsCheckComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): WordsCheckComponent
    }

    fun inject(fragment: WordsCheckFragment)
}