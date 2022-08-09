package com.hmyh.toyu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmyh.toyu.adapter.ToyCartAdapter
import com.hmyh.toyu.data.vos.ToyCartVO
import com.hmyh.toyu.databinding.FragmentCartBinding
import com.hmyh.toyu.databinding.FragmentHomeBinding
import com.hmyh.toyu.utils.getColorList
import com.hmyh.toyu.utils.getToyCartList
import com.hmyh.toyu.viewmodel.CartViewModel
import com.hmyh.toyu.viewmodel.HomeViewModel

class CartFragment : BaseFragment() {

    private lateinit var viewModel: CartViewModel
    private lateinit var binding: FragmentCartBinding

    private lateinit var mAdapter: ToyCartAdapter

    private var mTotalPrice: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpRecyclerView()

        setUpDataObservation()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[CartViewModel::class.java]
    }

    private fun setUpRecyclerView() {
        mAdapter = ToyCartAdapter(viewModel)
        binding.rvCart.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvCart.adapter = mAdapter

    }

    private fun setUpDataObservation() {
        viewModel.getToyCartListData().observe(viewLifecycleOwner, Observer {
            it?.let { toyCartList ->

                mTotalPrice = 0.0

                toyCartList.forEach { toyCart ->

                    var tempPrice = toyCart.price!! * toyCart.toyQtyCount
                    mTotalPrice = mTotalPrice?.plus(tempPrice)!!

                }

                mAdapter.setNewData(toyCartList as MutableList<ToyCartVO>)

                binding.tvTotalPrice.text = "You need to pay $${mTotalPrice}"
            }
        })
    }

}