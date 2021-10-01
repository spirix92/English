package com.selen.english.api.responce

import com.google.gson.annotations.SerializedName

/**
 * @author Pyaterko Aleksey
 */
class WordsResponse {

    @SerializedName("words_list")
    var wordsList: List<Word> = listOf()

    class Word {
        @SerializedName("english_word")
        var en: String = ""

        @SerializedName("russian_word")
        var ru: String = ""

        @SerializedName("checked")
        var check: Boolean = true
    }
}