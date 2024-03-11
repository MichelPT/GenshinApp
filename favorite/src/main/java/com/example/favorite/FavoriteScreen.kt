package com.example.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.di.favoriteModule
import com.example.genshinapp.ui.components.AgentsList
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.module.rememberKoinModules
import org.koin.core.annotation.KoinExperimentalAPI


@OptIn(KoinExperimentalAPI::class)
@Composable
fun FavoriteScreen(
    detailNavigation: (String) -> Unit,
) {
    rememberKoinModules(unloadModules = true) { listOf(favoriteModule) }
    val favoriteViewModel: FavoriteViewModel = koinViewModel()
    favoriteViewModel.favoriteAgents.observeAsState().value.let {
        AgentsList(
            modifier = Modifier,
            agentsData = it,
            detailNavigation = detailNavigation
        )
    }
}