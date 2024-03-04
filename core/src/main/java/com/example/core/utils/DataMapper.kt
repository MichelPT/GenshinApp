package com.example.core.utils

import com.example.core.data.source.local.entity.AgentEntity
import com.example.core.data.source.remote.response.AgentResponse
import com.example.core.domain.model.Agent


object DataMapper {
    fun mapResponsesToEntities(input: List<AgentResponse>): List<AgentEntity> {
        val agentList = ArrayList<AgentEntity>()
        input.map {
            val agent = AgentEntity(
                uuid = it.uuid?:"",
                displayName = it.displayName?:"",
                description =it.description?:"",
                role = it.role?.displayName?:"",
                displayIcon = it.displayIcon?:"",
                fullPortrait = it.fullPortrait?:"",
                isFavorite = false
            )
            agentList.add(agent)
        }
        return agentList
    }

    fun mapEntitiesToDomain(input: List<AgentEntity>): List<Agent> =
        input.map {
            Agent(
                uuid = it.uuid,
                displayName = it.displayName,
                description = it.description,
                role = it.role,
                displayIcon = it.displayIcon,
                fullPortrait = it.fullPortrait,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Agent) = AgentEntity(
        uuid = input.uuid,
        description = input.description,
        displayName = input.displayName,
        role = input.role,
        displayIcon = input.displayIcon,
        fullPortrait = input.fullPortrait,
        isFavorite = input.isFavorite
    )
}