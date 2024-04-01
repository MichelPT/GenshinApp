package com.example.core

import com.example.core.di.networkModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class RemoteTest : KoinTest {

    @Before
    open fun setUp() {
        this.configureDi()
    }

    @After
    open fun tearDown() {
        stopKoin()
    }

    private fun configureDi() {
        startKoin { modules(remoteTestModule) }
    }

    private val remoteTestModule = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://valorant-api.com/v1/agents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}}