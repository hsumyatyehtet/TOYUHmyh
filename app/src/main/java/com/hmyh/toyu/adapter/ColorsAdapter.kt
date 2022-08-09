package com.hmyh.toyu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.toyu.data.vos.ColorsListVO
import com.hmyh.toyu.databinding.ViewHolderInColorsBinding
import com.hmyh.toyu.view.holder.ColorsViewHolder

class ColorsAdapter: BaseRecyclerAdapter<ColorsViewHolder, ColorsListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
        return ColorsViewHolder(
            ViewHolderInColorsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}