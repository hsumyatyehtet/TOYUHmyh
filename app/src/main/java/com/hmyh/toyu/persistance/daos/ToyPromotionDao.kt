package com.hmyh.toyu.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import io.reactivex.Completable

@Dao
interface ToyPromotionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToyPromotionList(toyPromotionList: List<ToyPromotionListVO>): Completable

    @Query("select * from toy_promotion_list")
    fun retrieveToyPromotionList(): LiveData<List<ToyPromotionListVO>>

}