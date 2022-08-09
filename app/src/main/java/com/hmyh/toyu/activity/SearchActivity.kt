package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.hmyh.toyu.adapter.SearchAdapter
import com.hmyh.toyu.data.vos.ToyListVO
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

        setUpListener()
    }

    private fun setUpListener() {
        binding.etToySearch.requestFocus()

        val handler = Handler(Looper.getMainLooper())

        binding.etToySearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                handler.removeCallbacksAndMessages(null)
                handler.postDelayed({
                    s?.toString()?.let { searchWord ->
                        onChangeTextAfterSecond(searchWord)
                    }
                }, 600)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    private fun onChangeTextAfterSecond(searchWord: String) {

        if (searchWord == ""){
            mAdapter.setNewData(mutableListOf())
            binding.tvSearchResult.text = "No result"
        }
        else{
            viewModel.loadSearch(searchWord).observe(this, Observer {
                it?.let { toyList->
                    mAdapter.setNewData(toyList as MutableList<ToyListVO>)

                    var size = toyList.size
                    binding.tvSearchResult.text = "$size result found"
                }
            })
        }


    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[SearchViewModel::class.java]
    }

    private fun setUpRecyclerView() {
        mAdapter = SearchAdapter(viewModel)
        binding.rvSearch.layoutManager =
            GridLayoutManager(this,2)
        binding.rvSearch.adapter = mAdapter

    }

    companion object{

        fun newIntent(context: Context): Intent{
            return Intent(context,SearchActivity::class.java)
        }

    }

}