package com.qiqiaoban.rommel.rohub.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.qiqiaoban.rommel.rohub.helper.ToolBarHelper

/**
 * Created by 梁文硕 on 2017/4/12.
 */

abstract class ToolBarActivity : BaseActivity() {
    private var mToolBarHelper: ToolBarHelper? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        mToolBarHelper = ToolBarHelper(this, layoutResID)
        toolbar = mToolBarHelper!!.toolBar!!
        mActivity!!.setContentView(mToolBarHelper!!.contentView)
        setSupportActionBar(toolbar!!)
        /*自定义的一些操作*/
        onCreateCustomToolBar(toolbar!!)
    }

    fun onCreateCustomToolBar(toolbar: Toolbar) {
        toolbar.setContentInsetsRelative(0, 0)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //如果添加了右边菜单按钮,就需要调节标题位置
        if (menu.size() > 0) {
            val params = mToolBarHelper!!.titleView!!.layoutParams as Toolbar.LayoutParams
            params.setMargins(0, 0, 0, 0)
            mToolBarHelper!!.titleView!!.layoutParams = params
            mToolBarHelper!!.toolBar!!.title = ""
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        super.onResume()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun setToolbarTitle(title: String) {
        mToolBarHelper!!.titleView!!.text = title
    }

    fun setRightBtn(title: String, listener: View.OnClickListener) {
        mToolBarHelper!!.setRightBtn(title, listener)
    }

    fun setRightBtn(title: String) {
        mToolBarHelper!!.setRightBtn(title)
    }

    fun setRightBtnTitle(title: String) {
        mToolBarHelper!!.setRightBtnTitle(title)
    }

    fun setRightTextSize(size: Int) {
        mToolBarHelper!!.setRightTextSize(size)
    }
}