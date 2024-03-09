package com.example.genshinapp.di

import com.example.core.domain.usecase.AgentInteractor
import com.example.core.domain.usecase.AgentUseCase
import com.example.genshinapp.ui.screens.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideAgentUseCase(agentInteractor: AgentInteractor): AgentUseCase
}

