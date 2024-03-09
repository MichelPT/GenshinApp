package com.example.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.di.favoriteModule
import com.example.genshinapp.di.koinAppModule
import com.example.genshinapp.ui.components.AgentsList
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.loadKoinModules


@Composable
fun FavoriteScreen(
    detailNavigation: (String) -> Unit,
) {
    loadKoinModules(favoriteModule)
    val favoriteViewModel:FavoriteViewModel = koinViewModel()
    favoriteViewModel.favoriteAgents.observeAsState().value.let {
        AgentsList(
            modifier = Modifier,
            agentsData = it,
            detailNavigation = detailNavigation
        )
    }
}