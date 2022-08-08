package com.hmyh.toyu.utils

import com.hmyh.toyu.R
import com.hmyh.toyu.data.ToyPromotionVO

fun getToyPromotionList(): MutableList<ToyPromotionVO> {
    return mutableListOf(
        ToyPromotionVO(1, "Toy Couple", R.drawable.toy_promotion_couple),
        ToyPromotionVO(2, "Toy Squid Game", R.drawable.toy_promotion_squid_game)
    )
}