package com.hmyh.toyu.utils

import com.hmyh.toyu.R
import com.hmyh.toyu.data.vos.*

fun getToyPromotionList(): MutableList<ToyPromotionListVO> {
    return mutableListOf(
        ToyPromotionListVO(
            5, "Toy Couple", "Exclusive",
            R.drawable.toy_promotion_couple, 50
        ),
        ToyPromotionListVO(
            6, "Toy Squid Game", "Limited",
            R.drawable.toy_promotion_squid_game, 60
        )
    )
}

fun getToyList(): MutableList<ToyListVO> {
    return mutableListOf(
        ToyListVO(1, "Mini Bot", "NEW", R.drawable.toy_mini_bot, 10),
        ToyListVO(2, "Plastic Train", "Exclusive", R.drawable.toy_plastic_train, 20),
        ToyListVO(3, "Controller", "NEW", R.drawable.toy_controller, 30),
        ToyListVO(4, "Crocodile", "Limited", R.drawable.toy_crocodie, 40)
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

fun getToyDetail(): MutableList<ToyDetailVO> {
    return mutableListOf(
        ToyDetailVO(
            1, "Mini Bot", "NEW", R.drawable.toy_mini_bot,
            10, 25.0, 4.0f,
            "Dash teaches code in kid speak for girls and boys ages 6-11. A child’s first real robot friend. The physical robot comes with access to a virtual Dash robot that kids can program in a rich 3-D environment on screen.",
            getColorList(),
            OwnerVO(1, "Thomas", R.drawable.owner_thomas)
        ),

        ToyDetailVO(
            2, "Plastic Train", "Exclusive", R.drawable.toy_plastic_train,
            20, 50.4, 4.5f,
            "Vintage toy train, plastic toy, toy on wheels, steam locomotive, collection toys, locomotive.",
            getColorList(),
            OwnerVO(2, "LALISA", R.drawable.owner_lalisa)
        ),

        ToyDetailVO(
            3, "Controller", "NEW", R.drawable.toy_controller,
            30, 76.5, 3.5f,
            "Created from a premium piece of Tasmanian Oak hardwood, the Exectus Controller Stand defies gravity with its unique, cut-away design.",
            getColorList(),
            OwnerVO(3, "Aung Aung", R.drawable.owner_aung)
        ),

        ToyDetailVO(
            4, "Crocodile", "Limited", R.drawable.toy_crocodie,
            40, 80.00, 3.0f,
            "Beautiful Hand-painted wooden Crocodile Toy. Snaps his jaws when you push him!",
            getColorList(),
            OwnerVO(4, "Kyaw", R.drawable.owner_kyaw)
        ),

        ToyDetailVO(
            5, "Toy Couple", "Exclusive", R.drawable.toy_promotion_couple,
            50, 43.90, 4.2f,
            "Custom Anniversary Couple Bobblehead Free Shipping, Personalized Lover Statues, Personalized Couples Gifts.",
            getColorList(),
            OwnerVO(5, "Kaung", R.drawable.owner_kaung)
        ),

        ToyDetailVO(
            6, "Toy Squid Game", "Limited", R.drawable.toy_promotion_squid_game,
            60, 56.90, 4.0f,
            "Digitally printed BTS pillows on leather fabric. The inner filling is fiber.",
            getColorList(),
            OwnerVO(6, "Kahnt", R.drawable.owner_khant)
        )
    )
}