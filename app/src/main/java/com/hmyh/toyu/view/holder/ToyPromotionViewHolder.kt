package com.hmyh.toyu.view.holder

import com.bumptech.glide.Glide
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.databinding.ViewHolderInToyPromotionBinding

class ToyPromotionViewHolder(private val binding: ViewHolderInToyPromotionBinding)
    :BaseViewHolder<ToyPromotionListVO>(binding.root){


    override fun bindData(data: ToyPromotionListVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivToyPromotionItem)
    }
}