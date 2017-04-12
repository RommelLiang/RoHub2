package com.qiqiaoban.rommel.rohub.helper

import android.content.Context
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.qiqiaoban.rommel.rohub.R


class ToolBarHelper(/*上下文，创建view的时候需要用到*/
        private val mContext: Context, layoutId: Int) {

    /*base view*/
    var contentView: FrameLayout? = null
        private set

    /*用户定义的view*/
    private var mUserView: View? = null

    /*toolbar*/
    var toolBar: Toolbar? = null
        private set

    var titleView: TextView? = null
        private set
    private var rightView: TextView? = null

    /*视图构造器*/
    private val mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(mContext)
        /*初始化整个内容*/
        initContentView()
        /*初始化用户定义的布局*/
        initUserView(layoutId)
        /*初始化toolbar*/
        initToolBar()
    }

    private fun initContentView() {
        /*直接创建一个帧布局，作为视图容器的父容器*/
        contentView = FrameLayout(mContext)
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        contentView!!.layoutParams = params

    }

    private fun initToolBar() {
        /*通过inflater获取toolbar的布局文件*/
        val toolbar = mInflater.inflate(R.layout.toolbar, contentView)
        toolBar = toolbar.findViewById(R.id.toolbar) as Toolbar
        titleView = toolbar.findViewById(R.id.toolbarTitle) as TextView
        rightView = toolbar.findViewById(R.id.toolbarRight) as TextView
    }

    private fun initUserView(id: Int) {
        mUserView = mInflater.inflate(id, null)
        val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val typedArray = mContext.theme.obtainStyledAttributes(ATTRS)
        /*获取主题中定义的悬浮标志*/
        val overly = typedArray.getBoolean(0, false)
        /*获取主题中定义的toolbar的高度*/
        val toolBarSize = typedArray.getDimension(1, mContext.resources.getDimension(R.dimen.abc_action_bar_default_height_material).toInt().toFloat()).toInt()
        typedArray.recycle()
        /*如果是悬浮状态，则不需要设置间距*/
        params.topMargin = if (overly) 0 else toolBarSize
        contentView!!.addView(mUserView, params)

    }

    fun setRightBtn(title: String, listener: View.OnClickListener) {
        rightView!!.visibility = View.VISIBLE
        rightView!!.text = title
        rightView!!.setOnClickListener(listener)
    }

    fun setRightBtn(title: String) {
        rightView!!.visibility = View.VISIBLE
        rightView!!.text = title
    }

    fun setRightBtnTitle(title: String) {
        rightView!!.text = title
    }

    fun setRightTextSize(size: Int) {
        rightView!!.textSize = size.toFloat()
    }

    companion object {

        /*
    * 两个属性
    * 1、toolbar是否悬浮在窗口之上
    * 2、toolbar的高度获取
    * */
        private val ATTRS = intArrayOf(R.attr.windowActionBarOverlay, R.attr.actionBarSize)
    }
}
