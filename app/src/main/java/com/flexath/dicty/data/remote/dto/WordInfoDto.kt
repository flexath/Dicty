package com.flexath.dicty.data.remote.dto

import com.flexath.dicty.domain.model.Meaning
import com.flexath.dicty.domain.model.Phonetic
import com.flexath.dicty.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>?,
    val origin: String?,
    val phonetic: String?,
    val phonetics: List<PhoneticDto>?,
    val word: String?
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings?.map {
                it.toMeaning()
            },
            origin = origin,
            phonetic = phonetic,
            phonetics = phonetics?.map {
                it.toPhonetic()
            },
            word = word
        )
    }
}