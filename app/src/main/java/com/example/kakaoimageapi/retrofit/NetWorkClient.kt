package com.example.kakaoimageapi.retrofit

import com.example.kakaoimageapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetWorkClient {

    private const val BASE_URL = "https://dapi.kakao.com"


    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG)
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        else
            interceptor.level = HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    private val kakaoRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
            createOkHttpClient()
        ).build()

    val kakaoNetWork: NetWorkInterface = kakaoRetrofit.create(NetWorkInterface::class.java)

}