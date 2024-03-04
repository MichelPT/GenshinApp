package com.example.genshinapp.ui.factory

object DynamicFeaturePackageFactory {
    private const val PACKAGE = "com.example"

    object FavoriteDF{
        const val DF_FAVORITE_SCREEN = PACKAGE.plus("df_favorite.DFFavoriteScreenKt")
        const val COMPOSE_METHOD_NAME = "DFFavoriteScreen"
    }
}