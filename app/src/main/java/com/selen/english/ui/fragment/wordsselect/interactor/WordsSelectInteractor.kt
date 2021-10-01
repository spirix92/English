package com.selen.english.ui.fragment.wordsselect.interactor

import com.selen.english.di.repository.VerbsRepository
import com.selen.english.di.repository.WordsRepository
import com.selen.english.model.WordModel
import com.selen.english.type.WordsSelectType
import com.selen.english.ui.base.Interactor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class WordsSelectInteractor @Inject constructor(
    private val verbsRepository: VerbsRepository,
    private val wordsRepository: WordsRepository
) : Interactor() {

    suspend fun getWordsList(type: WordsSelectType): List<WordModel>? {
        return when (type) {
            WordsSelectType.WORDS -> wordsRepository.getAllWords()
            WordsSelectType.VERBS -> verbsRepository.getAllVerbs()
        }
    }

    suspend fun updateWordCheck(word: WordModel) {
        wordsRepository.updateCheck(word)
    }

    suspend fun updateVerbCheck(word: WordModel) {
        verbsRepository.updateCheck(word)
    }

    suspend fun updateAllWordsCheck(checked: Boolean) {
        wordsRepository.updateAllWordsCheck(checked)
    }

    suspend fun updateAllVerbsCheck(checked: Boolean) {
        verbsRepository.updateAllVerbsCheck(checked)
    }

}