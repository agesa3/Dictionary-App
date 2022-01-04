package com.agesadev.dictionaryapp.feature_dictionary.data.repository

import com.agesadev.dictionaryapp.core.core.util.Resource
import com.agesadev.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.agesadev.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.agesadev.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.agesadev.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word = word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfos))


        try {
            val remoteWordInfo = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordInfo.map { it.word })
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops! Something Went Wrong",
                    data = wordInfos

                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Oops! Something Went Wrong",
                    data = wordInfos

                )
            )
        }

    }
}