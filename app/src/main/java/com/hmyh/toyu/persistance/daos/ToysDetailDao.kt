package com.hmyh.toyu.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hmyh.toyu.data.vos.ToyDetailVO
import io.reactivex.Completable

@Dao
interface ToysDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToysDetailList(toyDetailList: List<ToyDetailVO>): Completable

    @Query("select * from toy_detail where id =:toysId")
    fun getToysDetailById(toysId: Int): LiveData<ToyDetailVO>

}