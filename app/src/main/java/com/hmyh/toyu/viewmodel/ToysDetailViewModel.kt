package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyDetailVO
import com.hmyh.toyu.utils.getToyDetail

class ToysDetailViewModel: ViewModel() {

    private val mModel: ToyUModel = ToyUModelImpl

    fun onUiReady(){
        mModel.insertToysDetail(getToyDetail())
    }

    fun getToysDetailByToyId(toyId: Int): LiveData<ToyDetailVO>{
        return mModel.getToysDetailByToyId(toyId)
    }

}