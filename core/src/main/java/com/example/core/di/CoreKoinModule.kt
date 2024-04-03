package com.example.core.di

import android.annotation.SuppressLint
import androidx.room.Room
import com.example.core.data.AgentRepository
import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.local.room.AgentDatabase
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiService
import com.example.core.domain.repository.IAgentRepository
import com.example.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<AgentDatabase>().agentDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            AgentDatabase::class.java, "Agents.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    val hostname = "tourism-api.dicoding.dev"
    val certificatePinner = CertificatePinner.Builder()
        .add(hostname, "sha256/Eq4tBBHvzZai3ns2UD/bP7afqF+JuLen30N7Ke9ZZ9I=")
        .add(hostname, "sha256/81Wf12bcLlFHQAfJluxnzZ6Frg+oJ9PWY/Wrwur8viQ=")
        .add(hostname, "sha256/hxqRlPTu1bMS/0DITB1SSu0vd4u/8l8TjPgfaAp63Gc=")
        .build()
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/agents/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

@SuppressLint("VisibleForTests")
val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IAgentRepository> {
        AgentRepository(
            get(),
            get(),
            get()
        )
    }
}