package com.example.genshinapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import com.example.genshinapp.ui.components.AgentsList
import com.example.genshinapp.ui.components.SearchBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel = koinViewModel(),
    detailNavigation: (String) -> Unit,
) {
    val searchKeyword by homeViewModel.searchKeyword
    homeViewModel.agentList.collectAsState(initial = Resource.Loading()).value.let { agentList ->
        when (agentList) {
            is Resource.Error -> {
                Row(
                    modifier.fillMaxSize(),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Error")
                }
            }

            is Resource.Loading -> {
                Row(
                    modifier.fillMaxSize(),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                HomeBody(
                    modifier = modifier,
                    keyword = searchKeyword,
                    onKeywordChange = homeViewModel::searchAgents,
                    agentsData = agentList.data!!,
                    detailNavigation = detailNavigation
                )
            }
        }
    }
}

@Composable
fun HomeBody(
    modifier: Modifier,
    keyword: String,
    onKeywordChange: (String) -> Unit,
    agentsData: List<Agent>,
    detailNavigation: (String) -> Unit,
) {
    Column {
        Spacer(modifier = Modifier.height(12.dp))
        SearchBar(keyword = keyword, onKeywordChange = onKeywordChange)
        AgentsList(
            agentsData = agentsData,
            modifier = modifier,
            detailNavigation = detailNavigation
        )
    }
}

