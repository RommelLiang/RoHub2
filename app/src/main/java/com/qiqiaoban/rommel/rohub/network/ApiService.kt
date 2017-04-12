package com.qiqiaoban.rommel.rohub.network

import com.qiqiaoban.rommel.rohub.bean.Users
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by 梁文硕 on 2017/4/6.
 */
class ApiService private constructor() {
    var apiManager: ApiManagerService
    companion object {
        val getInstance by lazy(LazyThreadSafetyMode.NONE){
            ApiService()
        }
    }

    init {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(4, TimeUnit.SECONDS).build()
        val retrofit = Retrofit.Builder()
                .baseUrl(HttpManager.ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiManager = retrofit.create(ApiManagerService::class.java)
    }


    interface ApiManagerService {

        @GET("http://ali-weather.showapi.com/hour24")
        fun getALiWeather(@Header("Authorization") APPCODE:String,@Query("area") area:String): Observable<String>

        @GET("users/{userName}")
        fun getUser(@Path("userName") userName:String): Observable<Users>
    }

}