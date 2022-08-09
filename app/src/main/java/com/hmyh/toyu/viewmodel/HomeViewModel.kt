package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.utils.getToyList
import com.hmyh.toyu.utils.getToyPromotionList

class HomeViewModel: ViewModel() {

    private val mModel: ToyUModel = ToyUModelImpl

    private var mToyList: LiveData<List<ToyListVO>> = mModel.getToyList()
    private var mToyPromotionList: LiveData<List<ToyPromotionListVO>> = mModel.getToyPromotionList()

    fun onUiReady(){
        mModel.insertToyList(getToyList())
        mModel.insertToyPromotionList(getToyPromotionList())
    }

    fun getToyListData(): LiveData<List<ToyListVO>>{
        return mToyList
    }

    fun getToyPromotionListData(): LiveData<List<ToyPromotionListVO>>{
        return mToyPromotionList
    }

}