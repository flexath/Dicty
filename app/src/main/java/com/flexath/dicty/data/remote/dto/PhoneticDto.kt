package com.flexath.dicty.data.remote.dto

import com.flexath.dicty.domain.model.Phonetic

data class PhoneticDto(
    val audio: String?,
    val text: String?
) {
    fun toPhonetic(): Phonetic {
        return Phonetic(
            audio = audio,
            text = text
        )
    }
}