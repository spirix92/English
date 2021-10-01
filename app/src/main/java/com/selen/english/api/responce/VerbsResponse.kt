package com.selen.english.api.responce

import com.google.gson.annotations.SerializedName

/**
 * @author Pyaterko Aleksey
 */
class VerbsResponse {

    @SerializedName("verbs_list")
    var verbsList: List<Verb> = listOf()

    class Verb {
        @SerializedName("english_verb")
        var en: String = ""

        @SerializedName("russian_verb")
        var ru: String = ""

        @SerializedName("checked")
        var check: Boolean = true
    }
}
