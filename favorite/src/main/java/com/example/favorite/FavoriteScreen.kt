package com.example.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.genshinapp.ui.State
import com.example.genshinapp.ui.components.AgentsList

@Composable
fun Favorite(
    modifier: Modifier = Modifier,
    detailNavigation: (String) -> Unit,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
) {
    favoriteViewModel.favoriteAgents.observeAsState().value.let {
        AgentsList(
            modifier = modifier,
            agentsData = it,
            detailNavigation = detailNavigation
        )
    }
}