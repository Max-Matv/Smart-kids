package com.matveichuk.smartkids.Apifragment.api

import com.matveichuk.smartkids.Apifragment.api.facts.Data
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface ApiCat {

    @GET("facts")
    fun getDataFact(): Observable<Data>
}

object ServiceBuilder {
    private val log = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(log)
        .build()


    val BASE_URL_1 = "https://cat-fact.herokuapp.com/"


    private val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_1)
        .client(client)
        .build()
        .create(ApiCat::class.java)

    fun buildService(): ApiCat {
        return retrofit
    }
}