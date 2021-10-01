package com.selen.english.type

/**
 * @author Pyaterko Aleksey
 */
enum class LessonType(
    val position: Int,
    val type: WordsSelectType,
    val isAll: Boolean,
    val isEnAnswer: Boolean
) {
    ALL_WORDS_EN_TO_RU(0, WordsSelectType.WORDS, true, true),
    ALL_WORDS_RU_TO_EN(1, WordsSelectType.WORDS, true, false),
    ALL_VERBS_EN_TO_RU(2, WordsSelectType.VERBS, true, true),
    ALL_VERBS_RU_TO_EN(3, WordsSelectType.VERBS, true, false),
    SELECTED_WORDS_EN_TO_RU(4, WordsSelectType.WORDS, false, true),
    SELECTED_WORDS_RU_TO_EN(5, WordsSelectType.WORDS, false, false),
    SELECTED_VERBS_EN_TO_RU(6, WordsSelectType.VERBS, false, true),
    SELECTED_VERBS_RU_TO_EN(7, WordsSelectType.VERBS, false, false);

    companion object {
        fun valueOf(position: Int): LessonType {
            return values().firstOrNull { it.position == position } ?: ALL_WORDS_EN_TO_RU
        }
    }
}