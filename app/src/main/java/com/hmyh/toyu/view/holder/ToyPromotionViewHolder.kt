package com.hmyh.toyu.view.holder

import com.bumptech.glide.Glide
import com.hmyh.toyu.data.ToyPromotionVO
import com.hmyh.toyu.databinding.ViewHolderInToyPromotionBinding

class ToyPromotionViewHolder(private val binding: ViewHolderInToyPromotionBinding)
    :BaseViewHolder<ToyPromotionVO>(binding.root){


    override fun bindData(data: ToyPromotionVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivToyPromotionItem)
    }
}