package com.example.core.data.source.local

import com.example.core.data.source.local.entity.AgentEntity
import com.example.core.data.source.local.room.AgentDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val agentDao: AgentDao) {
    fun getAllAgent(): Flow<List<AgentEntity>> = agentDao.getAllAgents()

    fun getFavoriteAgent(): Flow<List<AgentEntity>> = agentDao.getFavoriteAgent()

    suspend fun insertAgent(agentList: List<AgentEntity>) = agentDao.insertAgent(agentList)

    fun setFavoriteAgent(agent: AgentEntity, newState:Boolean){
        agent.isFavorite = newState
        agentDao.updateFavoriteAgent(agent)
    }
}