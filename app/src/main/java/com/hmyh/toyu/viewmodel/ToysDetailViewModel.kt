package com.hmyh.toyu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyDetailVO
import com.hmyh.toyu.utils.getToyDetail

class ToysDetailViewModel: ViewModel() {

    private val mModel: ToyUModel = ToyUModelImpl

    private var toyDetail: MutableLiveData<ToyDetailVO> = MutableLiveData()

    fun onUiReady(){
        mModel.insertToysDetail(getToyDetail())
    }

    fun getToysDetailByToyId(toyId: Int): LiveData<ToyDetailVO>{

        return mModel.getToysDetailByToyId(toyId)
    }

    fun setToyCart(toyDetailVO: ToyDetailVO){
        mModel.insertToyCart(toyDetailVO)
    }

}