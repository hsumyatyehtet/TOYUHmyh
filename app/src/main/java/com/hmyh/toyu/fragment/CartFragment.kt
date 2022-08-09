package com.hmyh.toyu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hmyh.toyu.databinding.FragmentCartBinding
import com.hmyh.toyu.databinding.FragmentHomeBinding

class CartFragment: BaseFragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }

}