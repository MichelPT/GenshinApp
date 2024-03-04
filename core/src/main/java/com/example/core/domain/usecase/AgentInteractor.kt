package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import com.example.core.domain.repository.IAgentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AgentInteractor @Inject constructor(private val agentRepository: IAgentRepository):
    AgentUseCase {
    override fun getAllAgents(): Flow<Resource<List<Agent>>> = agentRepository.getAllAgents()

    override fun getFavoriteAgent(): Flow<List<Agent>> = agentRepository.getFavoriteAgent()

    override fun setFavoriteAgent(agent: Agent, state: Boolean) = agentRepository.setFavoriteAgent(agent, state)
}