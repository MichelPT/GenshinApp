package com.example.genshinapp.ui.navigation

sealed class Route(val route: String) {
    data object Home : Route("homepage")
    data object Favorite : Route("favorite")
    data object Detail : Route("detail/{agentId}"){
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
