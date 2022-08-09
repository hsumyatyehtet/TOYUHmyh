package com.hmyh.toyu.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toy_cart")
data class ToyCartVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "toy_type")
    var toyType: String? = null,

    @ColumnInfo(name = "image")
    var image: Int? = null,

    @ColumnInfo(name = "qty")
    var qty: Int? = null,

    @ColumnInfo(name = "price")
    var price: Double? = null,

    @ColumnInfo(name = "rating")
    var rating: Float? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "available_color_list")
    var availableColorList: List<ColorsListVO>? = null,

    @Embedded(prefix = "owner_")
    var owner: OwnerVO? = null,

    @ColumnInfo(name = "toy_qty_count")
    var toyQtyCount: Int?=null

)