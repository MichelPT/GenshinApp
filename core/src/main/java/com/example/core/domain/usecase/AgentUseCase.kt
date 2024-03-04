package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import kotlinx.coroutines.flow.Flow

interface AgentUseCase {
    fun getAllAgents(): Flow<Resource<List<Agent>>>

    fun getFavoriteAgent(): Flow<List<Agent>>

    fun setFavoriteAgent(agent: Agent, state: Boolean)

}