package com.hmyh.toyu.view.holder

import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.databinding.ViewHolderInCartBinding

class ToyCartViewHolder(
    private val binding: ViewHolderInCartBinding
) : BaseViewHolder<ToyCartVO>(binding.root) {

    init {

    }

    override fun bindData(data: ToyCartVO) {
        mData = data

        if (data.toyType.equals("NEW")){
            binding.tvToyTypeCart.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorPrimary))
        }
        else{
            binding.tvToyTypeCart.setTextColor(ContextCompat.getColor(itemView.context, R.color.mainColor3))
        }

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivImageCart)
        binding.tvToyNameCart.text = data.name ?: ""
        binding.tvToyTypeCart.text = data.toyType ?: ""

        Glide.with(itemView.context)
            .load(data.owner?.image)
            .into(binding.ivOwnerCart)
        binding.tvOwnerNameCart.text = data.owner?.name ?: ""
        binding.tvToyItemRemain.text = "${data.qty} item left"
        binding.tvToyPriceCart.text = "$ ${data.price}"
        binding.tvToyCount.text = data.toyQtyCount.toString()

    }
}