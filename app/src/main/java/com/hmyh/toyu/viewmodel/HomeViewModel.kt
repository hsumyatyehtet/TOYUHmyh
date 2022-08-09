package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.utils.getToyList

class HomeViewModel: ViewModel() {

    private val mModel: ToyUModel = ToyUModelImpl

    private var mToyList: LiveData<List<ToyListVO>> = mModel.getToyList()

    fun onUiReady(){
        mModel.insertToyList(getToyList())
    }

    fun getToyListData(): LiveData<List<ToyListVO>>{
        return mToyList
    }

}