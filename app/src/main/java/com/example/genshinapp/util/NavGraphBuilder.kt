package com.example.genshinapp.util

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.genshinapp.ui.navigation.Route

fun NavGraphBuilder.favorite(
    modifier: Modifier = Modifier,
    detailNavigation: (String) -> Unit,
) {
    composable(route = Route.Favorite.route) {
        DFFavorite(modifier, detailNavigation)
    }
}