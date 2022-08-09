package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.adapter.SearchAdapter
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyListVO

class SearchViewModel: ViewModel(),SearchAdapter.Delegate {

    private val mModel: ToyUModel = ToyUModelImpl

    override fun onTapToyItem(toyId: Int) {

    }

    fun loadSearch(searchWord: String): LiveData<List<ToyListVO>> {
        return mModel.loadSearch(searchWord)
    }

}