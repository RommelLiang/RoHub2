package com.qiqiaoban.rommel.rohub.activity

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.qiqiaoban.rommel.rohub.R

class SplishActivity : BaseActivity() {

    override fun initDatas() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splish)
        
        /*ApiService
                .getInstance
                .apiManager
                .getUser("RommelLiang")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Users>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        Log.e("onError:", e.message)
                    }

                    override fun onNext(message: Users) {
                        Log.e("onNext", message.html_url)
                    }
                })*/
    }

}
