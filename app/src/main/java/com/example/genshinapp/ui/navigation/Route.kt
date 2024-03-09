package com.example.genshinapp.ui.navigation

import androidx.compose.ui.Modifier

sealed class Route(val route: String) {
    object Home : Route("homepage")
    object Favorite : Route("favorite")
    object Detail : Route("detail/{agentId}"){
        fun createRoute(agentId:String) = "detail/$agentId"
    }
}

//enum class BottomNavItem(var route:String) {
//    Favorite(Route.Favorite.route),
//}
//
//enum class Route(var route:String) {
//    Favorite("df_first")
//}
