package com.selen.english.database.dao

import androidx.room.*
import com.selen.english.database.entity.WordEntity

/**
 * @author Pyaterko Aleksey
 */
@Dao
interface WordsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: WordEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListWords(listWords: List<WordEntity>)

    @Update
    suspend fun updateWord(word: WordEntity)

    @Delete
    suspend fun deleteWord(word: WordEntity)

    @Query("DELETE FROM Words")
    suspend fun deleteAllWords()

    @Query("SELECT * FROM Words")
    suspend fun getAllWords(): List<WordEntity>?

    @Query("SELECT COUNT() FROM Words")
    suspend fun getCountWords(): Long

    @Query("UPDATE Words SET `check` = :checked WHERE enWord = :en")
    fun updateCheck(en: String, checked: Boolean)

    @Query("UPDATE Words SET `check` = :checked")
    fun updateAllCheck(checked: Boolean)
}