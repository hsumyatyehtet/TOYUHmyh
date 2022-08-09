package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmyh.toyu.adapter.ColorsAdapter
import com.hmyh.toyu.databinding.ActivityToyDetailBinding
import com.hmyh.toyu.utils.getColorList

class ToyDetailActivity: BaseActivity() {

    private lateinit var binding: ActivityToyDetailBinding

    private lateinit var mColorAdapter: ColorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        setUpDataObservation()

    }

    private fun setUpDataObservation() {
        mColorAdapter.setNewData(getColorList())
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