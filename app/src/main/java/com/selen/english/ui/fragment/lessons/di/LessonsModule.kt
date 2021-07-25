package com.selen.english.ui.fragment.lessons.di

import androidx.lifecycle.ViewModel
import com.selen.english.di.ViewModelKey
import com.selen.english.ui.fragment.lessons.LessonsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Pyaterko Aleksey
 */
@Module
abstract class LessonsModule {

    @Binds
    @IntoMap
    @ViewModelKey(LessonsViewModel::class)
    abstract fun bindViewModel(viewmodel: LessonsViewModel): ViewModel
}