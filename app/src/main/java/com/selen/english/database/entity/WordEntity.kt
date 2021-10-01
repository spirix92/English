package com.selen.english.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Pyaterko Aleksey
 */
@Entity(tableName = "Words")
data class WordEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name = "ruWord")
    var ru: String,

    @ColumnInfo(name = "enWord")
    var en: String,

    @ColumnInfo(name = "check")
    var check: Boolean
)