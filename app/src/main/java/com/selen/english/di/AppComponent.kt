package com.selen.english.di

import android.content.Context
import com.selen.english.ui.fragment.lessons.di.LessonsComponent
import com.selen.english.ui.fragment.settings.di.SettingsComponent
import com.selen.english.ui.fragment.wordscheck.di.WordsCheckComponent
import com.selen.english.ui.fragment.wordsselect.di.WordsSelectComponent
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
        GsonModule::class,
        RoomModule::class,
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

    fun settingsComponent(): SettingsComponent.Factory

    fun wordsSelectComponent(): WordsSelectComponent.Factory

    fun wordsCheckComponent(): WordsCheckComponent.Factory

}

@Module(
    subcomponents = []
)
object SubcomponentsModule