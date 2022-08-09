package com.hmyh.toyu

import android.app.Application
import android.content.Context
import com.hmyh.toyu.data.model.impl.ToyUModelImpl

/**
 * Created by Hsu Myat Ye Htet on August 9, 2022
 */
class ToyUApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        application = applicationContext

        ToyUModelImpl.init(applicationContext)
    }

    companion object{
        lateinit var application: Context
    }

}