package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.vos.ColorsListVO
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.databinding.ViewHolderInCartBinding
import com.hmyh.toyu.databinding.ViewHolderInColorsBinding
import com.hmyh.toyu.databinding.ViewHolderInToyBinding
import com.hmyh.toyu.view.holder.ColorsViewHolder
import com.hmyh.toyu.view.holder.ToyCartViewHolder

class ToyCartAdapter: BaseRecyclerAdapter<ToyCartViewHolder,ToyCartVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyCartViewHolder{
        return ToyCartViewHolder(
            ViewHolderInCartBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}