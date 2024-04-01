package com.example.core

import com.example.core.data.AgentRepository
import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import com.example.core.domain.usecase.AgentInteractor
import io.reactivex.Single
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class AgentUseCaseTest {
    @Mock
    lateinit var agentRepository: AgentRepository

    val agentUseCase by lazy { AgentInteractor(agentRepository) }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun `test get All agents`() {
        `when` (agentRepository.getAllAgents()).thenReturn(
                flowOf(
                    Resource.Success(
                        listOf(
                            Agent(
                                role = "student with a passion for coding",
                                uuid = "1234567890",
                                fullPortrait = "https://example.com/portrait.jpg",
                                description = "Agent description",
                                displayIcon = "https://example.com/icon.png",
                                displayName = "Michel",
                                isFavorite = false
                            )
                        )
                    )
                )
            )
        runBlocking {
            agentUseCase.getAllAgents().first().data?.get(0)?.let{
                assert(it.displayName == "Michel")
                assert(it.role == "student with a passion for coding")
                assert(it.description == "Agent description")
                assert(it.displayIcon == "https://example.com/icon.png")
                assert(it.fullPortrait == "https://example.com/portrait.jpg")
                assert(!it.isFavorite)
                assert(it.uuid == "1234567890")
            }
        }
    }
}
//@RunWith(MockitoJUnitRunner::class)
//class AgentUseCaseTest {
//    private lateinit var agentUseCase: AgentUseCase
//
//    private val dummyAgent =
//            Agent(
//                role = "student with a passion for coding",
//                uuid = "1234567890",
//                fullPortrait = "https://example.com/portrait.jpg",
//                description = "Agent description",
//                displayIcon = "https://example.com/icon.png",
//                displayName = "Michel",
//                isFavorite = false
//            )
//
//    @Mock
//    private lateinit var agentRepository: AgentRepository
//
//    @Before
//    fun setUp() {
//        agentUseCase = AgentInteractor(agentRepository)
//        `when`(agentUseCase.getAllAgents()).thenReturn(
//                flow {
//                    Resource.Success(
//                        listOf(
//                            Agent(
//                                role = "student with a passion for coding",
//                                uuid = "1234567890",
//                                fullPortrait = "https://example.com/portrait.jpg",
//                                description = "Agent description",
//                                displayIcon = "https://example.com/icon.png",
//                                displayName = "Michel",
//                                isFavorite = false
//                            )
//                        )
//                    )
//                }
//            )
//    }
//
//
//
//
//
//    @Test
//    fun `Get all agents`() {
//        var agents: Agent? = null
//        val agentsFlow = agentUseCase.getAllAgents()
//        runBlocking {
//            val agent = agentsFlow.first().data
//            agents = agent?.get(0)
//        }
//
//        verify(agentRepository).getAllAgents()
//        verifyNoMoreInteractions(agentRepository)
//        assertEquals(dummyAgent, agents)
//    }
//
//}