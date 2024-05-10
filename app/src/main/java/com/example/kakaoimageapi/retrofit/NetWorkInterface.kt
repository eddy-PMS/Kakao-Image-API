package com.example.kakaoimageapi.retrofit

import com.example.kakaoimageapi.data.KakaoDTO
import com.example.kakaoimageapi.data.KakaoResponse
import com.example.kakaoimageapi.data.documents
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val REST_API_KEY = "4842f6be044bd2efc2eb47cf17b9bd5e"

interface NetWorkInterface {
    @Headers("Authorization: KakaoAK ${REST_API_KEY}") // GET 요청에 필요한 주소
    @GET("v2/search/image")
    suspend fun searchImage(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ):KakaoResponse
}

