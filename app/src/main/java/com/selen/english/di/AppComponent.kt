package com.selen.english.di

import android.content.Context
import com.selen.english.ui.fragment.lessons.di.LessonsComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * @author Pyaterko Aleksey
 */
@Singleton
@Component(
    modules = [
        ViewModelBuilderModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun context(): Context

    fun lessonsComponent(): LessonsComponent.Factory

}

@Module(
    subcomponents = []
)
object SubcomponentsModule