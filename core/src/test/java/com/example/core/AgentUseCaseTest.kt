package com.example.core

import androidx.appcompat.widget.ResourceManagerInternal
import com.example.core.data.AgentRepository
import com.example.core.data.source.local.entity.AgentEntity
import com.example.core.domain.usecase.AgentInteractor
import com.example.core.domain.usecase.AgentUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class AgentUseCaseTest {
    private lateinit var agentUseCase: AgentUseCase

    @Mock
    private lateinit var agentRepository: AgentRepository

    @Before
    fun setUp() {
        agentUseCase = AgentInteractor(agentRepository)
        val dummyAgent = AgentEntity(
            role = "Just a student",
            uuid = "1234567890",
            fullPortrait = "https://example.com/portrait.jpg",
            description = "Agent description",
            displayIcon = "https://example.com/icon.png",
            displayName = "Michel"
        )
        `when`(agentRepository.getAllAgents())
    }

}