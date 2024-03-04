package com.example.genshinapp.ui.navigation

sealed class Route(val route: String) {
    object Home : Route("homepage")
    object Favorite : Route("favorite")
    object Detail : Route("detail/{agentId}"){
        fun createRoute(agentId:String) = "detail/$agentId"
    }
}