package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hmyh.toyu.databinding.ActivityGetStartBinding

class GetStartActivity: BaseActivity() {

    private lateinit var binding: ActivityGetStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGetStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context,GetStartActivity::class.java).apply {

            }
        }
    }

}