package com.qiqiaoban.rommel.rohub.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.qiqiaoban.rommel.rohub.R

class MainActivity : BaseActivity() {

    override fun initDatas() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    companion object {
        fun launch(activity: Activity) {
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }
    }
}
