package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hmyh.toyu.databinding.ActivitySearchBinding

class SearchActivity: BaseActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object{

        fun newIntent(context: Context): Intent{
            return Intent(context,SearchActivity::class.java)
        }

    }

}