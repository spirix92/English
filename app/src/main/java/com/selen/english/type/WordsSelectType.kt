package com.selen.english.type

/**
 * @author Pyaterko Aleksey
 */
enum class WordsSelectType(val position: Int, val unit: String) {
    WORDS(0, "слова"),
    VERBS(1, "глаголы");

    companion object {
        fun valueOf(position: Int): WordsSelectType {
            return values().firstOrNull { it.position == position } ?: WORDS
        }
    }
}