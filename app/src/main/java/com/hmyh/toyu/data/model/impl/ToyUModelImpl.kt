package com.hmyh.toyu.data.model.impl

import androidx.lifecycle.LiveData
import com.hmyh.toyu.data.model.BaseAppModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.vos.ToyDetailVO
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.utils.subscribeDBWithCompletable

object ToyUModelImpl: BaseAppModel(),ToyUModel {

    override fun insertToyList(toyList: List<ToyListVO>) {
        mDatabase.toyDao()
            .insertToyList(toyList)
            .subscribeDBWithCompletable()
    }

    override fun getToyList(): LiveData<List<ToyListVO>> {
        return mDatabase.toyDao().retrieveToyList()
    }

    override fun insertToyPromotionList(toyPromotionList: List<ToyPromotionListVO>) {
        mDatabase.toyPromotionDao()
            .insertToyPromotionList(toyPromotionList)
            .subscribeDBWithCompletable()
    }

    override fun getToyPromotionList(): LiveData<List<ToyPromotionListVO>> {
        return mDatabase.toyPromotionDao().retrieveToyPromotionList()
    }

    override fun insertToysDetail(toyDetailList: List<ToyDetailVO>) {
        mDatabase.toysDetailDao()
            .insertToysDetailList(toyDetailList)
            .subscribeDBWithCompletable()
    }

    override fun getToysDetailByToyId(toysId: Int): LiveData<ToyDetailVO> {
        return mDatabase.toysDetailDao().getToysDetailById(toysId)
    }

}