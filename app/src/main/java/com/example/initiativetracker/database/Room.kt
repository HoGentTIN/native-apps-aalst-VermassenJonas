package com.example.initiativetracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.initiativetracker.database.daos.MonsterDao
import com.example.initiativetracker.domain.Monster

@Database(
    entities = [Monster::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class Room : RoomDatabase() {
    abstract val monsterDao: MonsterDao

    companion object {
        @Volatile
        private var INSTANCE: Room? = null

        fun getInstance(context: Context): Room {
            synchronized(this) {
                var instance =
                    INSTANCE
                if (instance == null) {
                    instance = androidx.room.Room.databaseBuilder(
                        context.applicationContext,
                        Room::class.java,
                        "monster_database"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}