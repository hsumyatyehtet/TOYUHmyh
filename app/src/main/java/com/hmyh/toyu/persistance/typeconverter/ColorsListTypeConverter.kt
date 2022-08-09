package com.hmyh.toyu.persistance.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hmyh.toyu.data.vos.ColorsListVO

class ColorsListTypeConverter {

    @TypeConverter
    fun fromListToGson(list: List<ColorsListVO>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromGsonToList(json: String): List<ColorsListVO>? {
        val typeToken = object : TypeToken<List<ColorsListVO>>() {}.type
        return Gson().fromJson(json, typeToken)
    }
}