package com.hmyh.toyu.view.holder

import android.annotation.SuppressLint
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.hmyh.toyu.R
import com.hmyh.toyu.adapter.ToyCartAdapter
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.databinding.ViewHolderInCartBinding
import kotlinx.android.synthetic.main.view_holder_in_cart.view.*

class ToyCartViewHolder(
    private val binding: ViewHolderInCartBinding,
    private val delegate: ToyCartAdapter.Delegate
) : BaseViewHolder<ToyCartVO>(binding.root) {

    init {

        itemView.rlDesc.setOnClickListener {

            mData?.let { toyCart->

                if (toyCart.toyQtyCount >0){
                    toyCart.toyQtyCount--
                }

                delegate.onTapItem(toyCart)

            }

        }

        itemView.rlIncrease.setOnClickListener {
            mData?.let { toyCart->

                if (toyCart.toyQtyCount < toyCart.qty!!){
                    toyCart.toyQtyCount++
                }

                delegate.onTapItem(toyCart)

            }
        }

    }

    @SuppressLint("SetTextI18n")
    override fun bindData(data: ToyCartVO) {
        mData = data

        if (data.toyType.equals("NEW")){
            binding.tvToyTypeCart.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorPrimary))
        }
        else{
            binding.tvToyTypeCart.setTextColor(ContextCompat.getColor(itemView.context, R.color.mainColor3))
        }

        if (data.toyQtyCount == 0){
            Glide.with(itemView.context)
                .load(R.drawable.ic_check_false)
                .into(binding.ivChecked)
        }
        else{
            Glide.with(itemView.context)
                .load(R.drawable.ic_check_true)
                .into(binding.ivChecked)
        }

        var remainItem: Int?=null
        remainItem = data.qty!! - data.toyQtyCount

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivImageCart)
        binding.tvToyNameCart.text = data.name ?: ""
        binding.tvToyTypeCart.text = data.toyType ?: ""

        Glide.with(itemView.context)
            .load(data.owner?.image)
            .into(binding.ivOwnerCart)
        binding.tvOwnerNameCart.text = data.owner?.name ?: ""
        binding.tvToyItemRemain.text = "$remainItem item left"
        binding.tvToyPriceCart.text = "$ ${data.price}"
        binding.tvToyCount.text = data.toyQtyCount.toString()

    }
}