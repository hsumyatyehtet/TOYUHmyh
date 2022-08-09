package com.hmyh.toyu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmyh.toyu.adapter.ToyAdapter
import com.hmyh.toyu.adapter.ToyPromotionAdapter
import com.hmyh.toyu.databinding.FragmentHomeBinding
import com.hmyh.toyu.utils.getToyList
import com.hmyh.toyu.utils.getToyPromotionList

class HomeFragment: BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mToyPromotionAdapter: ToyPromotionAdapter
    private lateinit var mToyAdapter: ToyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpDataObservation()
    }

    private fun setUpDataObservation() {
        mToyPromotionAdapter.setNewData(getToyPromotionList())
        mToyAdapter.setNewData(getToyList())
    }

    private fun setUpRecyclerView() {
        mToyPromotionAdapter = ToyPromotionAdapter()
        binding.rvToyPromotion.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvToyPromotion.adapter = mToyPromotionAdapter

        mToyAdapter = ToyAdapter()
        binding.rvToy.layoutManager =
            GridLayoutManager(context,2)
        binding.rvToy.adapter = mToyAdapter
    }

}