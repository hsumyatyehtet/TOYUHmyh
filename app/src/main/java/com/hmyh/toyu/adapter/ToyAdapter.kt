package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.databinding.ViewHolderInToyBinding
import com.hmyh.toyu.view.holder.ToyViewHolder

class ToyAdapter(val delegate: Delegate)
    : BaseRecyclerAdapter<ToyViewHolder, ToyListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyViewHolder {
        return ToyViewHolder(
            ViewHolderInToyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            delegate
        )
    }

    interface Delegate{
        fun onTapToyItem(toyId: Int)
    }

}