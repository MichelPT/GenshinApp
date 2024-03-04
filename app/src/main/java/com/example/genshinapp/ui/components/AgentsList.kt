package com.example.genshinapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.core.domain.model.Agent

@Composable
fun AgentsList(
    modifier: Modifier,
    agentsData: List<Agent>?,
    detailNavigation: (String) -> Unit,
) {
    if (agentsData != null) {
        if (agentsData.isNotEmpty()) {
            Box(modifier = modifier) {
                LazyColumn {
                    items(agentsData, key = {it.uuid}){
                        AgentItem(
                            uuid = it.uuid,
                            displayName = it.displayName,
                            role = it.role,
                            description = it.description,
                            isFavorite = it.isFavorite,
                            modifier = modifier,
                            detailNavigation = detailNavigation,
                            displayIcon = it.displayIcon
                        )
                    }
                }
            }
        } else {
            Text(text = "No data!")
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize().testTag("empty_list")
        ) {
            Text(text = "There is no favorite found")
        }
    }
}