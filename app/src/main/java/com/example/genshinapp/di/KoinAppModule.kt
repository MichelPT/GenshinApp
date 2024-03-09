package com.example.genshinapp.di

import com.example.core.domain.usecase.AgentInteractor
import com.example.core.domain.usecase.AgentUseCase
import com.example.genshinapp.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinAppModule = module {
    factory<AgentUseCase> { AgentInteractor(get()) }
}
