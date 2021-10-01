package com.selen.english.di

import android.content.Context
import androidx.room.Room
import com.selen.english.database.LessonsDatabase
import com.selen.english.database.dao.VerbsDao
import com.selen.english.database.dao.WordsDao
import com.selen.english.di.repository.VerbsRepository
import com.selen.english.di.repository.WordsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Pyaterko Aleksey
 */
@Module
class RoomModule {

    @Named("databaseName")
    @Provides
    fun databaseName(): String {
        return "lessons_database"
    }

    @Singleton
    @Provides
    fun initRoom(@Named("databaseName") databaseName: String, context: Context): LessonsDatabase =
        Room.databaseBuilder(context, LessonsDatabase::class.java, databaseName)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun initVerbsDao(lessonsDatabase: LessonsDatabase): VerbsDao = lessonsDatabase.verbsDao()

    @Singleton
    @Provides
    fun initVerbsRepository(verbsDao: VerbsDao): VerbsRepository =
        VerbsRepository(verbsDao)

    @Singleton
    @Provides
    fun initWordsDao(lessonsDatabase: LessonsDatabase): WordsDao = lessonsDatabase.wordsDao()

    @Singleton
    @Provides
    fun initWordsRepository(wordsDao: WordsDao): WordsRepository =
        WordsRepository(wordsDao)

}