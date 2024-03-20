package com.flexath.dicty.domain.model

import com.flexath.dicty.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>?,
    val partOfSpeech: String?
)
