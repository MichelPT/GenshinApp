package com.example.genshinapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.Resource
import com.example.core.domain.usecase.AgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    agentUseCase: AgentUseCase,
) : ViewModel() {
    val agents = agentUseCase.getAllAgents().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), Resource.Loading())
}
