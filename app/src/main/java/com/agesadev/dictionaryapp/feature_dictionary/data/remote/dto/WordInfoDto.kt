package com.agesadev.dictionaryapp.feature_dictionary.data.remote.dto

import com.agesadev.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity
import com.agesadev.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning()   },
            origin = origin,
            phonetic = phonetic,
            word = word

        )
    }


}