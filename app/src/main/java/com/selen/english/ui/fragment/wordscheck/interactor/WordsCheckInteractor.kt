package com.selen.english.ui.fragment.wordscheck.interactor

import com.selen.english.di.repository.VerbsRepository
import com.selen.english.di.repository.WordsRepository
import com.selen.english.model.WordModel
import com.selen.english.type.LessonType
import com.selen.english.type.WordsSelectType
import com.selen.english.ui.base.Interactor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class WordsCheckInteractor @Inject constructor(
    private val verbsRepository: VerbsRepository,
    private val wordsRepository: WordsRepository
) : Interactor() {

    suspend fun getWordsList(type: LessonType): List<WordModel>? {
        val wordsList = when (type.type) {
            WordsSelectType.WORDS -> wordsRepository.getAllWords()
            WordsSelectType.VERBS -> verbsRepository.getAllVerbs()
        }

        return if (type.isAll) wordsList else wordsList?.filter { it.check }
    }

}