package com.hmyh.toyu.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hmyh.toyu.data.vos.*
import com.hmyh.toyu.persistance.daos.ToyDao
import com.hmyh.toyu.persistance.daos.ToyPromotionDao
import com.hmyh.toyu.persistance.daos.ToysDetailDao
import com.hmyh.toyu.persistance.typeconverter.ColorsListTypeConverter

@Database(
    entities = [
        ToyListVO::class,
        ToyPromotionListVO::class,
        ToyDetailVO::class,
        ColorsListVO::class,
        OwnerVO::class
    ],
    version = 1, exportSchema = false
)
@TypeConverters(ColorsListTypeConverter::class)
abstract class ToyUDatabase : RoomDatabase() {

    abstract fun toyDao(): ToyDao
    abstract fun toyPromotionDao(): ToyPromotionDao
    abstract fun toysDetailDao(): ToysDetailDao

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