package com.example.genshinapp.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import com.example.core.domain.usecase.AgentUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel(
    private val agentUseCase: AgentUseCase,
) : ViewModel() {
    private val _agentList: MutableStateFlow<Resource<List<Agent>>> =
        MutableStateFlow(Resource.Loading())
    val agentList: StateFlow<Resource<List<Agent>>> get() = _agentList.asStateFlow()

    private val _searchKeyword = mutableStateOf("")
    val searchKeyword: State<String> get() = _searchKeyword

    init {
        viewModelScope.launch {
            agentUseCase.getAllAgents().collect { listAgent ->
                filterAgents(listAgent)
            }
        }
    }

    private fun filterAgents(agents: Resource<List<Agent>>) {
        val keyword = _searchKeyword.value
        _agentList.value = if (keyword.isBlank()) {
            agents
        } else {
            val filteredAgents = agents.data?.filter { agent ->
                agent.displayName.contains(keyword, ignoreCase = true)
            }
            Resource.Success(filteredAgents ?: emptyList())
        }
    }

    fun searchAgents(keyword: String) {
        _searchKeyword.value = keyword
        filterAgents(_agentList.value)
    }

}
