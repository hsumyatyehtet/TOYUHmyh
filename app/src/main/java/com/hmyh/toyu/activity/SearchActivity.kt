package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.hmyh.toyu.adapter.SearchAdapter
import com.hmyh.toyu.databinding.ActivitySearchBinding
import com.hmyh.toyu.utils.getToyList
import com.hmyh.toyu.viewmodel.SearchViewModel

class SearchActivity: BaseActivity() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: ActivitySearchBinding

    private lateinit var mAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        setUpRecyclerView()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[SearchViewModel::class.java]
    }

    private fun setUpRecyclerView() {
        mAdapter = SearchAdapter(viewModel)
        binding.rvSearch.layoutManager =
            GridLayoutManager(this,2)
        binding.rvSearch.adapter = mAdapter

        mAdapter.setNewData(getToyList())
    }

    companion object{

        fun newIntent(context: Context): Intent{
            return Intent(context,SearchActivity::class.java)
        }

    }

}