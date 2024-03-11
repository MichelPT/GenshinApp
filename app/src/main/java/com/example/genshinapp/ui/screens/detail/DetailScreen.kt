package com.example.genshinapp.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.core.data.Resource
import com.example.core.domain.model.Agent
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier,
    agentId: String,
    detailViewModel: DetailViewModel = koinViewModel(),
) {
    var detailedAgent: Agent?
    detailViewModel.certainAgent.collectAsStateWithLifecycle().value.let {
        when (it) {
            is Resource.Error -> {
                Row(
                    modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Error")
                }
            }

            is Resource.Loading -> {
                Row(
                    modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Resource.Success -> {
                it.data?.forEach { agent ->
                    if (agent.uuid == agentId) {
                        detailedAgent = agent
                        DetailPage(
                            modifier = modifier,
                            agent = detailedAgent!!,
                            detailViewModel = detailViewModel
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun DetailPage(
    modifier: Modifier,
    agent: Agent,
    detailViewModel: DetailViewModel,
) {
    val isFav = remember { mutableStateOf(agent.isFavorite) }
    Column(
        modifier.fillMaxSize(),
    )
    {
        AsyncImage(
            model = agent.displayIcon,
            contentDescription = agent.displayName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(text = "\n${agent.displayName}\n")
        Text(text = "Description\t: ${agent.description}\n")
        Text(text = "Role\t: ${agent.role}\n")
        FloatingActionButton(onClick = {
            isFav.value = !isFav.value
            detailViewModel.setFavorite(agent, isFav.value)
        }) {
            Icon(
                imageVector = if (isFav.value) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Add Favorite Agent"
            )
        }
    }
}