package com.flexath.dicty.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flexath.dicty.data.local.dao.WordInfoDao
import com.flexath.dicty.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val wordInfoDao: WordInfoDao
}