package com.hmyh.toyu.data.model.impl

import androidx.lifecycle.LiveData
import com.hmyh.toyu.data.model.BaseAppModel
import com.hmyh.toyu.data.model.ToyUModel
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.data.vos.ToyDetailVO
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.utils.subscribeDBWithCompletable

object ToyUModelImpl: BaseAppModel(),ToyUModel {

    private var toyId: Int?=null

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

    override fun insertToyCart(toysDetailVO: ToyDetailVO) {

        var toyQtuCount: Int = 1

        if (toysDetailVO.id == toyId){
            toyQtuCount++
        }

        toyId = toysDetailVO.id

        var toyCartVO = ToyCartVO(toysDetailVO.id,toysDetailVO.name,toysDetailVO.toyType,toysDetailVO.image,
        toysDetailVO.qty,toysDetailVO.price,toysDetailVO.rating,toysDetailVO.description,toysDetailVO.availableColorList,
        toysDetailVO.owner,toyQtuCount)

        mDatabase.toyCartDao().insertToyCart(toyCartVO).subscribeDBWithCompletable()

    }

    override fun getToysCartDataList(): LiveData<List<ToyCartVO>> {
        return mDatabase.toyCartDao().retrieveToyCartList()
    }

    override fun insertToyCartByCart(toyCartVO: ToyCartVO) {
        mDatabase.toyCartDao().insertToyCart(toyCartVO).subscribeDBWithCompletable()
    }

}