package com.flexath.dicty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.flexath.dicty.data.local.entity.WordInfoEntity

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfo(wordInfoList: List<WordInfoEntity>)

    @Query("DELETE FROM WordInfoEntity WHERE word IN(:wordList)")
    suspend fun deleteWordInfo(wordList: List<String>)

    @Query("SELECT * FROM WordInfoEntity WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordInfo(word:String): List<WordInfoEntity>
}