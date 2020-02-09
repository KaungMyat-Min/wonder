package com.kaungmyatmin.wonder.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kaungmyatmin.wonder.models.Wonder

@Database(entities = [Wonder::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun wonderDao():WonderDao

    companion object{
        val DATABASE_NAME: String = "app_db"
    }


}








