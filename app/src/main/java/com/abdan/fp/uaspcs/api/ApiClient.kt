package com.abdan.fp.uaspcs.api

import com.abdan.fp.uaspcs.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val httpClient = OkHttpClient.Builder().apply {
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
    }.build()


    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl(BuildConfig.BASE_URL_TSDB)
            addConverterFactory(GsonConverterFactory.create())
        }
    }

    val instance: ApiService by lazy {
        retrofit
            .build()
            .create(ApiService::class.java)
    }

}