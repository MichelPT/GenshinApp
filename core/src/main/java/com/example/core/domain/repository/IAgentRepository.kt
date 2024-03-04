package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import kotlinx.coroutines.flow.Flow

interface IAgentRepository {
    fun getAllAgents(): Flow<Resource<List<Agent>>>

    fun getFavoriteAgent(): Flow<List<Agent>>

    fun setFavoriteAgent(agent: Agent, state: Boolean)

}