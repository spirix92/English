package com.selen.english.di.mapper

import com.selen.english.api.responce.VerbsResponse
import com.selen.english.database.entity.VerbEntity
import com.selen.english.model.WordModel
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author Pyaterko Aleksey
 */
@Mapper
interface VerbsMapper {

    companion object : VerbsMapper by INSTANCE

    fun fromVerbEntityToVerbModel(entity: VerbEntity): WordModel

    fun fromVerbsListResponseToVerbsListModel(entityList: List<VerbsResponse.Verb>): List<WordModel>

    fun fromVerbsListEntityToVerbsListModel(entityList: List<VerbEntity>?): List<WordModel>?

    fun fromVerbModelToVerbEntity(model: WordModel): VerbEntity

    fun fromVerbsListModelToVerbsListEntity(modelList: List<WordModel>?): List<VerbEntity>?

}

private val INSTANCE = Mappers.getMapper(VerbsMapper::class.java)