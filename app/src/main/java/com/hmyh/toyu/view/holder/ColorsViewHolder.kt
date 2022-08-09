package com.hmyh.toyu.view.holder

import com.bumptech.glide.Glide
import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.ColorsListVO
import com.hmyh.toyu.databinding.ViewHolderInColorsBinding

class ColorsViewHolder(private val binding: ViewHolderInColorsBinding)
    :BaseViewHolder<ColorsListVO>(binding.root){


    override fun bindData(data: ColorsListVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivColor)
    }
}