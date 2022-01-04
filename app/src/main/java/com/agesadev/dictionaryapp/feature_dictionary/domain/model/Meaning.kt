package com.agesadev.dictionaryapp.feature_dictionary.domain.model

import com.agesadev.dictionaryapp.feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)
