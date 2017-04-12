package com.qiqiaoban.rommel.rohub

import android.app.Application
import com.qiqiaoban.rommel.rohub.utils.SPUtils

/**
 * Created by 梁文硕 on 2017/4/5.
 */

class RoBubApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SPUtils.init(this)
    }
}
