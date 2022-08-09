package com.hmyh.toyu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmyh.toyu.adapter.SearchAdapter
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.model.impl.ToyUModelImpl
import com.hmyh.toyu.data.vos.ToyListVO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel(),SearchAdapter.Delegate {

    private val mModel: ToyUModel = ToyUModelImpl

    private var navigateToToyDetail: MutableLiveData<Int> = MutableLiveData()

    fun loadSearch(searchWord: String): LiveData<List<ToyListVO>> {
        return mModel.loadSearch(searchWord)
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