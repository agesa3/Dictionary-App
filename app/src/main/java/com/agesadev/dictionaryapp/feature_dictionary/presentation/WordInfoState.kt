package com.agesadev.dictionaryapp.feature_dictionary.presentation

import com.agesadev.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
