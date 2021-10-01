package com.selen.english.di.mapper

import com.selen.english.api.responce.WordsResponse
import com.selen.english.database.entity.WordEntity
import com.selen.english.model.WordModel
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author Pyaterko Aleksey
 */
@Mapper
interface WordsMapper {

    companion object : WordsMapper by INSTANCE

    fun fromWordEntityToWordModel(entity: WordEntity): WordModel

    fun fromWordsListResponseToWordsListModel(entityList: List<WordsResponse.Word>): List<WordModel>

    fun fromWordsListEntityToWordsListModel(entityList: List<WordEntity>?): List<WordModel>?

    fun fromWordModelToWordEntity(model: WordModel): WordEntity

    fun fromWordsListModelToWordsListEntity(modelList: List<WordModel>?): List<WordEntity>?

}

private val INSTANCE = Mappers.getMapper(WordsMapper::class.java)