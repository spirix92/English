package com.selen.english.database.dao

import androidx.room.*
import com.selen.english.database.entity.VerbEntity

/**
 * @author Pyaterko Aleksey
 */
@Dao
interface VerbsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVerb(verb: VerbEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListVerbs(listVerbs: List<VerbEntity>)

    @Update
    suspend fun updateVerb(verb: VerbEntity)

    @Delete
    suspend fun deleteVerb(verb: VerbEntity)

    @Query("DELETE FROM Verbs")
    suspend fun deleteAllVerbs()

    @Query("SELECT * FROM Verbs")
    suspend fun getAllVerbs(): List<VerbEntity>?

    @Query("SELECT COUNT() FROM Verbs")
    suspend fun getCountWords(): Long

    @Query("UPDATE Verbs SET `check` = :checked WHERE enVerb = :en")
    fun updateCheck(en: String, checked: Boolean)

    @Query("UPDATE Verbs SET `check` = :checked")
    fun updateAllVerbsCheck(checked: Boolean)
}