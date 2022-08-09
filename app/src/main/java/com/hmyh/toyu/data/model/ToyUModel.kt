package com.hmyh.toyu.data.model

import androidx.lifecycle.LiveData
import com.hmyh.toyu.data.vos.ToyListVO

interface ToyUModel {

    fun insertToyList(toyList: List<ToyListVO>)
    fun getToyList(): LiveData<List<ToyListVO>>

}