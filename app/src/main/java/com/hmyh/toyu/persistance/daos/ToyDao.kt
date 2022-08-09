package com.hmyh.toyu.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hmyh.toyu.data.vos.ToyListVO
import io.reactivex.Completable

@Dao
interface ToyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToyList(toyList: List<ToyListVO>): Completable

    @Query("select * from toy_list")
    fun retrieveToyList(): LiveData<List<ToyListVO>>

    @Query("select * from toy_list where name like :searchWord")
    fun retrieveToyListBySearch(searchWord: String): LiveData<List<ToyListVO>>

}