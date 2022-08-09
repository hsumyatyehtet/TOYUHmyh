package com.hmyh.toyu.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.persistance.daos.ToyDao

@Database(entities = [ToyListVO::class],
    version = 1, exportSchema = false)
abstract class ToyUDatabase : RoomDatabase() {

    abstract fun toyDao(): ToyDao

    companion object {

        @Volatile
        private var INSTANCE: ToyUDatabase? = null

        private const val DB_NAME = "ToyU.db"

        fun getDatabase(context: Context): ToyUDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ToyUDatabase::class.java, DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }

}