package com.hmyh.toyu.utils

import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.ColorsListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.data.vos.ToyListVO

fun getToyPromotionList(): MutableList<ToyPromotionListVO> {
    return mutableListOf(
        ToyPromotionListVO(5, "Toy Couple","Exclusive",
            R.drawable.toy_promotion_couple,50),
        ToyPromotionListVO(6, "Toy Squid Game","Limited",
            R.drawable.toy_promotion_squid_game,60)
    )
}

fun getToyList(): MutableList<ToyListVO> {
    return mutableListOf(
        ToyListVO(1, "Mini Bot", "NEW", R.drawable.toy_mini_bot,10),
        ToyListVO(2, "Plastic Train", "Exclusive", R.drawable.toy_plastic_train,20),
        ToyListVO(3, "Controller", "NEW", R.drawable.toy_controller,30),
        ToyListVO(4, "Crocodile", "Limited", R.drawable.toy_crocodie,40)
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