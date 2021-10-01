package com.selen.english.ui.fragment.wordscheck.di

import androidx.lifecycle.ViewModel
import com.selen.english.di.ViewModelKey
import com.selen.english.ui.fragment.wordscheck.WordsCheckViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Pyaterko Aleksey
 */
@Module
abstract class WordsCheckModule {

    @Binds
    @IntoMap
    @ViewModelKey(WordsCheckViewModel::class)
    abstract fun bindViewModel(viewmodel: WordsCheckViewModel): ViewModel
}