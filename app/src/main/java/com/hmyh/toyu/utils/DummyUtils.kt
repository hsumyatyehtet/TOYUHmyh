package com.hmyh.toyu.utils

import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.ColorsListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.data.vos.ToyListVO

fun getToyPromotionList(): MutableList<ToyPromotionListVO> {
    return mutableListOf(
        ToyPromotionListVO(5, "Toy Couple", R.drawable.toy_promotion_couple),
        ToyPromotionListVO(6, "Toy Squid Game", R.drawable.toy_promotion_squid_game)
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

fun getColorList(): MutableList<ColorsListVO> {
    return mutableListOf(
        ColorsListVO(1, R.drawable.circle_yellow),
        ColorsListVO(2, R.drawable.circle_orange),
        ColorsListVO(3, R.drawable.circle_purple),
        ColorsListVO(4, R.drawable.circle_pink)
    )
}