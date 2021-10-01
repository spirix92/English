package com.selen.english.di.repository

import com.selen.english.database.dao.WordsDao
import com.selen.english.di.mapper.WordsMapper
import com.selen.english.model.WordModel

/**
 * @author Pyaterko Aleksey
 */
class WordsRepository constructor(var wordsDao: WordsDao) {

    private val wordsMapper = WordsMapper

    suspend fun insertWordsList(modelList: List<WordModel>) {
        wordsMapper.fromWordsListModelToWordsListEntity(modelList)?.let {
            wordsDao.insertListWords(it)
        }
    }

    suspend fun getAllWords(): List<WordModel>? {
        return wordsMapper.fromWordsListEntityToWordsListModel(wordsDao.getAllWords())
    }

    suspend fun updateCheck(word: WordModel) {
        wordsDao.updateCheck(word.en, word.check)
    }

    suspend fun updateAllWordsCheck(checked: Boolean) {
        wordsDao.updateAllCheck(checked)
    }

    suspend fun deleteAllWords() {
        wordsDao.deleteAllWords()
    }

}