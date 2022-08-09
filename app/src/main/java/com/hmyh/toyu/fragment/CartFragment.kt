package com.hmyh.toyu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmyh.toyu.adapter.ToyCartAdapter
import com.hmyh.toyu.databinding.FragmentCartBinding
import com.hmyh.toyu.databinding.FragmentHomeBinding
import com.hmyh.toyu.utils.getColorList
import com.hmyh.toyu.utils.getToyCartList

class CartFragment: BaseFragment() {

    private lateinit var binding: FragmentCartBinding

    private lateinit var mAdapter: ToyCartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mAdapter = ToyCartAdapter()
        binding.rvCart.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvCart.adapter = mAdapter

        mAdapter.setNewData(getToyCartList())
    }

}