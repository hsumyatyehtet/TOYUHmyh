package com.hmyh.toyu.view.holder

import com.bumptech.glide.Glide
import com.hmyh.toyu.adapter.ToyPromotionAdapter
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.databinding.ViewHolderInToyPromotionBinding

class ToyPromotionViewHolder(
    private val binding: ViewHolderInToyPromotionBinding,
    private val delegate: ToyPromotionAdapter.Delegate
    )
    :BaseViewHolder<ToyPromotionListVO>(binding.root){

    init {
        binding.root.setOnClickListener {
            mData?.let { toyPromotion->
                toyPromotion.id?.let { toyId->
                    delegate.onTapToyPromotionItem(toyId)
                }
            }
        }
    }

    override fun bindData(data: ToyPromotionListVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivToyPromotionItem)
    }
}