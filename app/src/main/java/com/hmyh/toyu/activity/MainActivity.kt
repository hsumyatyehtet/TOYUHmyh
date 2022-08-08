package com.hmyh.toyu.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.hmyh.toyu.R
import com.hmyh.toyu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomBar()
    }

    @SuppressLint("WrongConstant")
    private fun setUpBottomBar() {
        binding.bottomNavBar.labelVisibilityMode = 1
        binding.bottomNavBar.background =
            ContextCompat.getDrawable(this,R.drawable.bg_bottom_bar)

        val dimensionInDp = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 20.0f,
            resources.displayMetrics
        ).toInt()
        binding.bottomNavBar.itemIconSize = dimensionInDp
    }

    companion object{

        fun newIntent(context: Context): Intent{
            return Intent(context,MainActivity::class.java)
        }

    }

}