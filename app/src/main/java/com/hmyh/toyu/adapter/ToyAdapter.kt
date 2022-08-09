package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.ToyPromotionVO
import com.hmyh.toyu.data.ToyVO
import com.hmyh.toyu.databinding.ViewHolderInToyBinding
import com.hmyh.toyu.databinding.ViewHolderInToyPromotionBinding
import com.hmyh.toyu.view.holder.ToyPromotionViewHolder
import com.hmyh.toyu.view.holder.ToyViewHolder

class ToyAdapter: BaseRecyclerAdapter<ToyViewHolder,ToyVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyViewHolder {
        return ToyViewHolder(
            ViewHolderInToyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}