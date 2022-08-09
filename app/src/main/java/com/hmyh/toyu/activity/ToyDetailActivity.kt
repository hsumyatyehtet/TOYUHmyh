package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.hmyh.toyu.R
import com.hmyh.toyu.adapter.ColorsAdapter
import com.hmyh.toyu.data.vos.ColorsListVO
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.data.vos.ToyDetailVO
import com.hmyh.toyu.databinding.ActivityToyDetailBinding
import com.hmyh.toyu.utils.getColorList
import com.hmyh.toyu.viewmodel.HomeViewModel
import com.hmyh.toyu.viewmodel.ToysDetailViewModel
import kotlin.reflect.typeOf

class ToyDetailActivity: BaseActivity() {

    private lateinit var viewModel: ToysDetailViewModel
    private lateinit var binding: ActivityToyDetailBinding

    private lateinit var mColorAdapter: ColorsAdapter

    private var toysId: Int?=null

    private var mToyDetailVo: ToyDetailVO?=null
    private var mToyCartVo: ToyCartVO?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        getDataFromIntent()
        setUpRecyclerView()

        setUpOnUiReady()
        setUpDataObservation()
        setUpListener()

    }

    private fun setUpListener() {
        binding.ivBackDetail.setOnClickListener {
            finish()
        }

        binding.rlAddToCart.setOnClickListener {
            mToyDetailVo?.let { data ->
                viewModel.setToyCart(data,mToyCartVo)
            }
            Toast.makeText(this,"Item Added",Toast.LENGTH_SHORT).show()
        }

    }

    private fun getDataFromIntent() {
        intent.getIntExtra(EXTRA_TOY_ID,0).let {
            toysId = it
        }
    }

    private fun setUpOnUiReady() {
        viewModel.onUiReady()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[ToysDetailViewModel::class.java]
    }

    private fun setUpDataObservation() {

        toysId?.let { mToyId->
            viewModel.getToysDetailByToyId(mToyId).observe(this, Observer {
                it?.let { toyDetail->
                    mToyDetailVo = toyDetail
                    setUpData(toyDetail)
                }
            })
        }

        toysId?.let { id->
            viewModel.getToysCartByToyId(id).observe(this, Observer {
                it?.let { toyCartVO ->
                    mToyCartVo = toyCartVO
                }
            })
        }

    }

    private fun setUpData(toyDetail: ToyDetailVO) {

        if (toyDetail.toyType.equals("NEW")){
            binding.tvToyTypeDetail.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        }
        else{
            binding.tvToyTypeDetail.setTextColor(ContextCompat.getColor(this, R.color.mainColor3))
        }

        Glide.with(this)
            .load(toyDetail.image)
            .into(binding.ivDetailImage)

        binding.tvToyNameDetail.text = toyDetail.name ?: ""
        binding.tvToyTypeDetail.text = toyDetail.toyType ?: ""
        binding.tvToyPrice.text = "$ ${toyDetail.price}"
        binding.tvToyDescDetail.text = toyDetail.description ?: ""
        binding.tvRating.text = toyDetail.rating.toString()

        binding.ratingBar.rating = toyDetail.rating ?: 0f

        toyDetail.availableColorList?.let { colorList->
            mColorAdapter.setNewData(colorList as MutableList<ColorsListVO>)
        }

        Glide.with(this)
            .load(toyDetail.owner?.image)
            .into(binding.ivOwner)
        binding.tvOwnerName.text = toyDetail.owner?.name ?: ""

    }

    private fun setUpRecyclerView() {
        mColorAdapter = ColorsAdapter()
        binding.rvAvailableColor.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvAvailableColor.adapter = mColorAdapter
    }

    companion object{
        const val EXTRA_TOY_ID="extra toy id"

        fun newIntent(context: Context,toyId: Int): Intent{
            return Intent(context,ToyDetailActivity::class.java).apply {
                putExtra(EXTRA_TOY_ID,toyId)
            }
        }
    }

}