package com.selen.english.ui.fragment.wordscheck

import com.selen.english.model.WordForCheckModel
import com.selen.english.model.WordModel
import com.selen.english.type.LessonType
import com.selen.english.ui.base.BaseViewModel
import com.selen.english.ui.base.SingleEventLiveData
import com.selen.english.ui.fragment.wordscheck.interactor.WordsCheckInteractor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class WordsCheckViewModel @Inject constructor(private val wordsSelectInteractor: WordsCheckInteractor) :
    BaseViewModel() {

    val wordsLiveData = SingleEventLiveData<List<WordForCheckModel>>()

    override fun onStart() {}

    fun getWordsList(type: LessonType) {
        doWork {
            val answer = wordsSelectInteractor.getWordsList(type)?.map {
                if (type.isEnAnswer) createEnToRU(it) else createRUToEn(it)
            }
            if (!answer.isNullOrEmpty()) {
                wordsLiveData.postValue(answer.shuffled())
            }
        }
    }

    private fun createEnToRU(word: WordModel): WordForCheckModel {
        return WordForCheckModel().apply {
            question = word.en
            answer = word.ru
        }
    }

    private fun createRUToEn(word: WordModel): WordForCheckModel {
        return WordForCheckModel().apply {
            question = word.ru
            answer = word.en
        }
    }

}