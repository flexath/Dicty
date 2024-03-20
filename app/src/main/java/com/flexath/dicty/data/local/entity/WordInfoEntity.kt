package com.flexath.dicty.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flexath.dicty.domain.model.Meaning
import com.flexath.dicty.domain.model.Phonetic
import com.flexath.dicty.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id:Int? = null,
    val meanings: List<Meaning>?,
    val origin: String?,
    val phonetic: String?,
    val phonetics: List<Phonetic>?,
    val word: String?
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            origin = origin,
            phonetic = phonetic,
            phonetics = phonetics,
            word = word
        )
    }
}
