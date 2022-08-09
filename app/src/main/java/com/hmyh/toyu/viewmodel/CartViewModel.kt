package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyCartVO

class CartViewModel: ViewModel() {

    private val mModel: ToyUModel = ToyUModelImpl

    private var mToyCartList: LiveData<List<ToyCartVO>> = mModel.getToysCartDataList()

    fun getToyCartListData(): LiveData<List<ToyCartVO>>{
        return mToyCartList
    }

}