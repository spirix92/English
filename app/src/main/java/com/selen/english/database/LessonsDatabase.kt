package com.selen.english.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.selen.english.database.dao.VerbsDao
import com.selen.english.database.dao.WordsDao
import com.selen.english.database.entity.VerbEntity
import com.selen.english.database.entity.WordEntity

/**
 * @author Pyaterko Aleksey
 */
@Database(
    version = 1,
    exportSchema = false,
    entities = [
        WordEntity::class,
        VerbEntity::class
    ]
)
abstract class LessonsDatabase : RoomDatabase() {
    abstract fun wordsDao(): WordsDao
    abstract fun verbsDao(): VerbsDao
}