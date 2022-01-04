package com.agesadev.dictionaryapp.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agesadev.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity
import com.agesadev.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase:RoomDatabase() {

    abstract val dao:WordInfoDao
}