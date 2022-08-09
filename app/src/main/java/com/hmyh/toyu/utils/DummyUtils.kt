package com.hmyh.toyu.utils

import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.data.vos.ToyListVO

fun getToyPromotionList(): MutableList<ToyPromotionListVO> {
    return mutableListOf(
        ToyPromotionListVO(1, "Toy Couple", R.drawable.toy_promotion_couple),
        ToyPromotionListVO(2, "Toy Squid Game", R.drawable.toy_promotion_squid_game)
    )
}

fun getToyList(): MutableList<ToyListVO> {
    return mutableListOf(
        ToyListVO(1, "Mini Bot", "NEW", R.drawable.toy_mini_bot),
        ToyListVO(2, "Plastic Train", "Exclusive", R.drawable.toy_plastic_train),
        ToyListVO(3, "Controller", "NEW", R.drawable.toy_controller),
        ToyListVO(4, "Crocodile", "Limited", R.drawable.toy_crocodie)
    )
}