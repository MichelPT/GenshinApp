package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.source.local.room.AgentDao
import com.example.core.data.source.local.room.AgentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AgentDatabase = Room.databaseBuilder(
        context,
        AgentDatabase::class.java, "Agents.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideAgentDao(database: AgentDatabase): AgentDao = database.agentDao()
}

