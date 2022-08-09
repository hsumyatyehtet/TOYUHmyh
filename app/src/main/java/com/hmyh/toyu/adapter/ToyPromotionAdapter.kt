package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.ToyPromotionVO
import com.hmyh.toyu.databinding.ViewHolderInToyPromotionBinding
import com.hmyh.toyu.view.holder.ToyPromotionViewHolder

class ToyPromotionAdapter: BaseRecyclerAdapter<ToyPromotionViewHolder,ToyPromotionVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyPromotionViewHolder {
        return ToyPromotionViewHolder(
            ViewHolderInToyPromotionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}