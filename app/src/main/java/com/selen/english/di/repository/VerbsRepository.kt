package com.selen.english.di.repository

import com.selen.english.database.dao.VerbsDao
import com.selen.english.di.mapper.VerbsMapper
import com.selen.english.model.WordModel

/**
 * @author Pyaterko Aleksey
 */
class VerbsRepository constructor(var verbsDao: VerbsDao) {

    private val verbsMapper = VerbsMapper

    suspend fun insertVerbsList(modelList: List<WordModel>) {
        verbsMapper.fromVerbsListModelToVerbsListEntity(modelList)?.let {
            verbsDao.insertListVerbs(it)
        }
    }

    suspend fun getAllVerbs(): List<WordModel>? {
        return verbsMapper.fromVerbsListEntityToVerbsListModel(verbsDao.getAllVerbs())
    }

    suspend fun updateCheck(word: WordModel) {
        verbsDao.updateCheck(word.en, word.check)
    }

    suspend fun updateAllVerbsCheck(checked: Boolean) {
        verbsDao.updateAllVerbsCheck(checked)
    }

    suspend fun deleteAllVerbs() {
        verbsDao.deleteAllVerbs()
    }

}