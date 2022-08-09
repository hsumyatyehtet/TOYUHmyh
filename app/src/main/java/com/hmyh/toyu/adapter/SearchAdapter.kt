package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.databinding.ViewHolderInSearchBinding
import com.hmyh.toyu.view.holder.SearchViewHolder

class SearchAdapter(val delegate: Delegate)
    : BaseRecyclerAdapter<SearchViewHolder, ToyListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ViewHolderInSearchBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            delegate
        )
    }

    interface Delegate{
        fun onTapToyItem(toyId: Int)
    }

}