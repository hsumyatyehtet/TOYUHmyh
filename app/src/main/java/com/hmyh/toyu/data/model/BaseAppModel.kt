package com.hmyh.toyu.data.model

import android.content.Context
import com.hmyh.toyu.persistance.ToyUDatabase


/**
 * Created by Hsu Myat Ye Htet on August 9, 2022
 */
abstract class BaseAppModel: BaseModel() {

   protected lateinit var mDatabase: ToyUDatabase

    override fun init(context: Context) {

        initDatabase(context)
    }

    private fun initDatabase(context: Context) {
        mDatabase = ToyUDatabase.getDatabase(context)
    }

}