package com.selen.english.ui.fragment.settings.interactor

import android.content.Context
import com.google.gson.Gson
import com.selen.english.R
import com.selen.english.api.responce.VerbsResponse
import com.selen.english.api.responce.WordsResponse
import com.selen.english.di.mapper.VerbsMapper
import com.selen.english.di.mapper.WordsMapper
import com.selen.english.di.repository.VerbsRepository
import com.selen.english.di.repository.WordsRepository
import com.selen.english.ui.base.Interactor
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class SettingsInteractor @Inject constructor(
    private val verbsRepository: VerbsRepository,
    private val wordsRepository: WordsRepository,
    private val context: Context,
    private val gson: Gson
) : Interactor() {

    private val verbsMapper = VerbsMapper
    private val wordsMapper = WordsMapper

    suspend fun reloadVerbs() {
        verbsRepository.deleteAllVerbs()

        val response = kotlin.runCatching {
            gson.fromJson(
                InputStreamReader(context.resources.openRawResource(R.raw.all_verbs_response)),
                VerbsResponse::class.java
            )
        }

        if (response.isSuccess) {
            val verbsList = verbsMapper.fromVerbsListResponseToVerbsListModel(
                response.getOrDefault(VerbsResponse()).verbsList
            )
            verbsRepository.insertVerbsList(verbsList)
        }
    }

    suspend fun reloadWords() {
        wordsRepository.deleteAllWords()

        val response = kotlin.runCatching {
            gson.fromJson(
                InputStreamReader(context.resources.openRawResource(R.raw.all_words_response)),
                WordsResponse::class.java
            )
        }

        if (response.isSuccess) {
            val wordsList = wordsMapper.fromWordsListResponseToWordsListModel(
                response.getOrDefault(WordsResponse()).wordsList
            )
            wordsRepository.insertWordsList(wordsList)
        }
    }

}