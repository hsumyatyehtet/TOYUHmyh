package com.hmyh.toyu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hmyh.toyu.databinding.FragmentFavBinding
import com.hmyh.toyu.databinding.FragmentHomeBinding

class FavFragment: BaseFragment() {

    private lateinit var binding: FragmentFavBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavBinding.inflate(inflater,container,false)
        return binding.root
    }

}