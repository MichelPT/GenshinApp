package com.example.genshinapp.ui.utilities

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.genshinapp.ui.navigation.Route

fun NavGraphBuilder.favorite(detailNavigation: (String)->Unit) {
    composable(route = Route.Favorite.route) {
        FavoriteDF(detailNavigation = detailNavigation)
    }
}

//fun NavGraphBuilder.dfSecond(paddingValues: PaddingValues, text: String) {
//    composable(route = Screens.DFSecond.route) {
//        DFSecondScreen(paddingValues = paddingValues, text = text)
//    }
//}
//
//fun NavGraphBuilder.dfThird(paddingValues: PaddingValues, text: String) {
//    composable(route = Screens.DFThird.route) {
//        DFThirdScreen(paddingValues = paddingValues, text = text)
//    }
//}