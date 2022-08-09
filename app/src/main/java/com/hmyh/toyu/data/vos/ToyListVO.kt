package com.hmyh.toyu.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toy_list")
data class ToyListVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?=null,

    @ColumnInfo(name = "name")
    var name: String?=null,

    @ColumnInfo(name="toy_type")
    var toyType: String?=null,

    @ColumnInfo(name = "image")
    var image: Int?=null

)