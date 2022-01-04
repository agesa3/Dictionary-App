package com.agesadev.dictionaryapp.feature_dictionary.domain.repository

import com.agesadev.dictionaryapp.core.core.util.Resource
import com.agesadev.dictionaryapp.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>


}