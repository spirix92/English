package com.selen.english.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Pyaterko Aleksey
 */
@Entity(tableName = "Verbs")
data class VerbEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name = "ruVerb")
    var ru: String,

    @ColumnInfo(name = "enVerb")
    var en: String,

    @ColumnInfo(name = "check")
    var check: Boolean
)