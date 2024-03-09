@file:Suppress("SpellCheckingInspection")

package com.example.genshinapp.ui.factory

object DynamicFeaturePackageFactory {
    private const val PACKAGE = "com.example."

    object FavoriteDF{
        const val DF_FAVORITE_SCREEN = PACKAGE.plus("favorite.FavoriteScreenKt")
        const val COMPOSE_METHOD_NAME = "FavoriteScreen"
    }
}