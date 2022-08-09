package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.databinding.ViewHolderInToyPromotionBinding
import com.hmyh.toyu.view.holder.ToyPromotionViewHolder

class ToyPromotionAdapter(private val delegate: Delegate)
    : BaseRecyclerAdapter<ToyPromotionViewHolder, ToyPromotionListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyPromotionViewHolder {
        return ToyPromotionViewHolder(
            ViewHolderInToyPromotionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            delegate
        )
    }

    interface Delegate{
        fun onTapToyPromotionItem(toyId: Int
        )
    }

}