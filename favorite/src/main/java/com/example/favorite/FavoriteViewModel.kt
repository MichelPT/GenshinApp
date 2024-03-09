package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.AgentUseCase


class FavoriteViewModel(
    agentUseCase: AgentUseCase,
) : ViewModel() {
    val favoriteAgents = agentUseCase.getFavoriteAgent().asLiveData()
}