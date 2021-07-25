package com.selen.english.data

import com.google.gson.annotations.SerializedName

/**
 * Модель для получения списка слов
 *
 * @author Pyaterko Aleksey
 */
class WordsResponse {

    @SerializedName("words_list")
    var wordsList: List<Words> = listOf()

    class Words {
        @SerializedName("english_word")
        var englishWord: String = ""

        @SerializedName("russian_word")
        var russianWord: String = ""
    }

}