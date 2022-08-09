package com.hmyh.toyu.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hmyh.toyu.databinding.ActivityToyDetailBinding

class ToyDetailActivity: BaseActivity() {

    private lateinit var binding: ActivityToyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object{
        const val EXTRA_TOY_ID="extra toy id"

        fun newIntent(context: Context,toyId: Int): Intent{
            return Intent(context,ToyDetailActivity::class.java).apply {
                putExtra(EXTRA_TOY_ID,toyId)
            }
        }
    }

}