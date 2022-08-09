package com.hmyh.toyu.utils

import com.hmyh.toyu.R
import com.hmyh.toyu.data.ToyPromotionVO
import com.hmyh.toyu.data.ToyVO

fun getToyPromotionList(): MutableList<ToyPromotionVO> {
    return mutableListOf(
        ToyPromotionVO(1, "Toy Couple", R.drawable.toy_promotion_couple),
        ToyPromotionVO(2, "Toy Squid Game", R.drawable.toy_promotion_squid_game)
    )
}

fun getToyList(): MutableList<ToyVO> {
    return mutableListOf(
        ToyVO(1, "Mini Bot", "NEW", R.drawable.toy_mini_bot),
        ToyVO(2, "Plastic Train", "Exclusive", R.drawable.toy_plastic_train),
        ToyVO(3, "Controller", "NEW", R.drawable.toy_controller),
        ToyVO(4, "Crocodile", "Limited", R.drawable.toy_crocodie)
    )
}