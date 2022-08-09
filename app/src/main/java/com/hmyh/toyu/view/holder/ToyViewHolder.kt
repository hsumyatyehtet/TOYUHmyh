package com.hmyh.toyu.view.holder

import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.databinding.ViewHolderInToyBinding

class ToyViewHolder(private val binding: ViewHolderInToyBinding)
    :BaseViewHolder<ToyListVO>(binding.root){


    override fun bindData(data: ToyListVO) {
        mData = data

        if (data.toyType.equals("NEW")){
            binding.tvToyType.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorPrimary))
        }
        else{
            binding.tvToyType.setTextColor(ContextCompat.getColor(itemView.context, R.color.mainColor3))
        }

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivToyItem)

        binding.tvToyName.text = data.name
        binding.tvToyType.text = data.toyType

    }
}