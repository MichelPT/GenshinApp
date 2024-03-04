package com.example.genshinapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import com.example.core.domain.usecase.AgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val agentUseCase: AgentUseCase
) :ViewModel() {
    val certainAgent = agentUseCase.getAllAgents().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), Resource.Loading())

   fun setFavorite(agent: Agent, state:Boolean)=
       agentUseCase.setFavoriteAgent(agent, state)

}