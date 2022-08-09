package com.hmyh.toyu.activity

import android.os.Bundle
import com.hmyh.toyu.databinding.ActivitySplashScreenBinding

class SplashScreenActivity: BaseActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpScreenTimer()
    }

    private fun setUpScreenTimer() {
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1000)
                } catch (e: InterruptedException) {
                }
                runOnUiThread {
                    startActivity(GetStartActivity.newIntent(this@SplashScreenActivity))
                    this@SplashScreenActivity.finish()
                }
            }
        }
        thread.start()
    }

}