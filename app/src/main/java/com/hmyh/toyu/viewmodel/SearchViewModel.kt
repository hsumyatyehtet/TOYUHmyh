package com.hmyh.toyu.viewmodel

import androidx.lifecycle.ViewModel
import com.hmyh.toyu.adapter.SearchAdapter

class SearchViewModel: ViewModel(),SearchAdapter.Delegate {

    override fun onTapToyItem(toyId: Int) {

    }
}