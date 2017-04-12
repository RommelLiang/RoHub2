package com.qiqiaoban.rommel.rohub.activity

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by 梁文硕 on 2017/4/12.
 */

abstract class BaseActivity : AppCompatActivity() {
    protected var mActivity: Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        initDatas()
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        initView()
    }

    override fun setContentView(view: View) {
        super.setContentView(view)
        initView()
    }

    override fun onResume() {
        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        super.onResume()

    }

    private fun initView() {}
    protected abstract fun initDatas()
    override fun onDestroy() {
        super.onDestroy()
    }
}