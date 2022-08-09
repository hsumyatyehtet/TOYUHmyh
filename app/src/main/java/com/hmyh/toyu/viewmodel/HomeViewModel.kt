package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.adapter.ToyAdapter
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.utils.getToyList
import com.hmyh.toyu.utils.getToyPromotionList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() ,ToyAdapter.Delegate{

    private val mModel: ToyUModel = ToyUModelImpl

    private var mToyList: LiveData<List<ToyListVO>> = mModel.getToyList()
    private var mToyPromotionList: LiveData<List<ToyPromotionListVO>> = mModel.getToyPromotionList()

    private var navigateToToyDetail: MutableLiveData<Int> = MutableLiveData()

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

    override fun onTapToyItem(toyId: Int) {
        GlobalScope.launch {
            navigateToToyDetail.postValue(toyId)
        }
    }

    fun getNavigateToToyDetail(): LiveData<Int>{
        return navigateToToyDetail
    }

}