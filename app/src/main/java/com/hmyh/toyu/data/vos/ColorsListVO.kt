package com.hmyh.toyu.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "color_list")
data class ColorsListVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "color_id")
    var colorId: Int? = null,

    @ColumnInfo(name = "image")
    var image: Int? = null

)