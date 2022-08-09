package com.hmyh.toyu.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hmyh.toyu.data.vos.ToyCartVO
import io.reactivex.Completable

@Dao
interface ToyCartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(toyCartVO: ToyCartVO): Completable

    @Query("select * from toy_cart")
    fun retrieveToyCartList(): LiveData<List<ToyCartVO>>

}