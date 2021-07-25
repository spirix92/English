package com.selen.english.ui.fragment.lessons.interactor

import com.selen.english.ui.base.Interactor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class LessonsInteractor @Inject constructor(
//    private val appDatabase: AppDatabase
) : Interactor() {

    suspend fun disconnect() {
//        appDatabase.authorizationDao().deleteAll()
    }

    fun test(): String {
        return "work"
    }
}