package com.hmyh.toyu.data.model

import androidx.lifecycle.LiveData
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO

interface ToyUModel {

    fun insertToyList(toyList: List<ToyListVO>)
    fun getToyList(): LiveData<List<ToyListVO>>

    fun insertToyPromotionList(toyPromotionList: List<ToyPromotionListVO>)
    fun getToyPromotionList(): LiveData<List<ToyPromotionListVO>>

}