package com.hmyh.toyu.data.model.impl

import androidx.lifecycle.LiveData
import com.hmyh.toyu.data.model.BaseAppModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.utils.subscribeDBWithCompletable

object ToyUModelImpl: BaseAppModel(),ToyUModel {

    override fun insertToyList(toyList: List<ToyListVO>) {
        mDatabase.toyDao().insertToyList(toyList).subscribeDBWithCompletable()
    }

    override fun getToyList(): LiveData<List<ToyListVO>> {
        return mDatabase.toyDao().retrieveToyList()
    }

}