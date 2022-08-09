package com.hmyh.toyu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmyh.toyu.activity.ToyDetailActivity
import com.hmyh.toyu.adapter.ToyAdapter
import com.hmyh.toyu.adapter.ToyPromotionAdapter
import com.hmyh.toyu.data.vos.ToyListVO
import com.hmyh.toyu.data.vos.ToyPromotionListVO
import com.hmyh.toyu.databinding.FragmentHomeBinding
import com.hmyh.toyu.utils.getToyPromotionList
import com.hmyh.toyu.viewmodel.HomeViewModel

class HomeFragment: BaseFragment() {

    private lateinit var viewModel: HomeViewModel
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

        setUpViewModel()
        setUpRecyclerView()

        setUpOnUiReady()
        setUpDataObservation()
    }

    private fun setUpOnUiReady() {
        viewModel.onUiReady()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[HomeViewModel::class.java]
    }

    private fun setUpDataObservation() {

        viewModel.getToyListData().observe(viewLifecycleOwner, Observer {
            it?.let { toyList->
                mToyAdapter.setNewData(toyList as MutableList<ToyListVO>)
            }
        })

        viewModel.getToyPromotionListData().observe(viewLifecycleOwner, Observer {
            it?.let { toyPromotionList->
                mToyPromotionAdapter.setNewData(toyPromotionList as MutableList<ToyPromotionListVO>)
            }
        })

        viewModel.getNavigateToToyDetail().observe(viewLifecycleOwner, Observer {
            it?.let { toyId->
                startActivity(ToyDetailActivity.newIntent(requireContext(),toyId))
            }
        })

    }

    private fun setUpRecyclerView() {
        mToyPromotionAdapter = ToyPromotionAdapter()
        binding.rvToyPromotion.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvToyPromotion.adapter = mToyPromotionAdapter

        mToyAdapter = ToyAdapter(viewModel)
        binding.rvToy.layoutManager =
            GridLayoutManager(context,2)
        binding.rvToy.adapter = mToyAdapter
    }

}