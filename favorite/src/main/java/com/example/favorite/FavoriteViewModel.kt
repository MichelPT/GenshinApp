package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.AgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    agentUseCase: AgentUseCase
) : ViewModel() {
    val favoriteAgents = agentUseCase.getFavoriteAgent().asLiveData()
}