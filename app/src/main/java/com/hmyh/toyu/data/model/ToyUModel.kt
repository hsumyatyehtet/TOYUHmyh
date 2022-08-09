package com.hmyh.toyu.data.model

import androidx.lifecycle.LiveData
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.data.vos.ToyDetailVO
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.persistance.daos.ToysDetailDao

interface ToyUModel {

    fun insertToyList(toyList: List<ToyListVO>)
    fun getToyList(): LiveData<List<ToyListVO>>

    fun insertToyPromotionList(toyPromotionList: List<ToyPromotionListVO>)
    fun getToyPromotionList(): LiveData<List<ToyPromotionListVO>>

    fun insertToysDetail(toyDetailList: List<ToyDetailVO>)
    fun getToysDetailByToyId(toysId: Int): LiveData<ToyDetailVO>

    fun insertToyCart(toysDetailVO: ToyDetailVO,toyCartVO: ToyCartVO?)
    fun getToysCartDataList(): LiveData<List<ToyCartVO>>
    fun getToysCartById(toyId: Int): LiveData<ToyCartVO>

    fun insertToyCartByCart(toyCartVO: ToyCartVO)

}