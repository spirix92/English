package com.selen.english.ui.fragment.lessons.di

import com.selen.english.ui.fragment.lessons.LessonsFragment
import dagger.Subcomponent

/**
 * @author Pyaterko Aleksey
 */
@Subcomponent(modules = [LessonsModule::class])
interface LessonsComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): LessonsComponent
    }

    fun inject(fragment: LessonsFragment)
}