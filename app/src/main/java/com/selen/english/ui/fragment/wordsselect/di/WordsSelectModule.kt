package com.selen.english.ui.fragment.wordsselect.di

import androidx.lifecycle.ViewModel
import com.selen.english.di.ViewModelKey
import com.selen.english.ui.fragment.wordsselect.WordsSelectViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Pyaterko Aleksey
 */
@Module
abstract class WordsSelectModule {

    @Binds
    @IntoMap
    @ViewModelKey(WordsSelectViewModel::class)
    abstract fun bindViewModel(viewmodel: WordsSelectViewModel): ViewModel
}