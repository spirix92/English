package com.selen.english.ui.fragment.wordsselect

import com.selen.english.model.WordModel
import com.selen.english.type.WordsSelectType
import com.selen.english.ui.base.BaseViewModel
import com.selen.english.ui.base.SingleEventLiveData
import com.selen.english.ui.fragment.wordsselect.interactor.WordsSelectInteractor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class WordsSelectViewModel @Inject constructor(private val wordsSelectInteractor: WordsSelectInteractor) :
    BaseViewModel() {

    val wordsLiveData = SingleEventLiveData<List<WordModel>>()

    override fun onStart() {}

    fun getWordsList(type: WordsSelectType) {
        doWork {
            wordsSelectInteractor.getWordsList(type)?.let {
                wordsLiveData.postValue(it)
            }
        }
    }

    fun updateWordCheck(word: WordModel) {
        doWork {
            wordsSelectInteractor.updateWordCheck(word)
        }
    }

    fun updateVerbCheck(word: WordModel) {
        doWork {
            wordsSelectInteractor.updateVerbCheck(word)
        }
    }

    fun updateAllWordsCheck(checked: Boolean) {
        doWork {
            wordsSelectInteractor.updateAllWordsCheck(checked)
        }
    }

    fun updateAllVerbsCheck(checked: Boolean) {
        doWork {
            wordsSelectInteractor.updateAllVerbsCheck(checked)
        }
    }

}