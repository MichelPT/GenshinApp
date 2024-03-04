package com.example.genshinapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.data.Resource
import com.example.genshinapp.ui.components.AgentsList

@Composable
fun HomeScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    detailNavigation: (String) -> Unit,
) {
    homeViewModel.agents.collectAsStateWithLifecycle().value.let {
        when(it){
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
                AgentsList(modifier = modifier, agentsData = it.data!!, detailNavigation = detailNavigation)
            }
        }
    }
}