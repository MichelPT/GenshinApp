package com.example.core.data

import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.AgentResponse
import com.example.core.domain.model.Agent
import com.example.core.domain.repository.IAgentRepository
import com.example.core.utils.AppExecutors
import com.example.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AgentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : IAgentRepository {
    override fun getAllAgents(): Flow<Resource<List<Agent>>> =
        object : NetworkBoundResource<List<Agent>, List<AgentResponse>>() {
            override fun loadFromDB(): Flow<List<Agent>> {
                return localDataSource.getAllAgent().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<AgentResponse>>> =
                remoteDataSource.getAllAgents()

            override suspend fun saveCallResult(data: List<AgentResponse>) {
                val agentList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAgent(agentList)
            }

            override fun shouldFetch(data: List<Agent>?): Boolean = true

        }.asFlow()

    override fun getFavoriteAgent(): Flow<List<Agent>> {
        return localDataSource.getFavoriteAgent().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteAgent(agent: Agent, state: Boolean) {
        val agentEntity = DataMapper.mapDomainToEntity(agent)
        appExecutors.diskIO().execute{
            localDataSource.setFavoriteAgent(agentEntity, state)
        }
    }



}