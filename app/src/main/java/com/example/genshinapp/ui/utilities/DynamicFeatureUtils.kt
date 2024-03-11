package com.example.genshinapp.ui.utilities

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import com.example.genshinapp.ui.components.DFNotFoundScreen
import com.example.genshinapp.ui.factory.DynamicFeaturePackageFactory

object DynamicFeatureUtils {

    @Composable
    fun dfFavorite(detailNavigation: (String)->Unit): Boolean {
        return loadDF(
            detailNavigation = detailNavigation,
            className = DynamicFeaturePackageFactory.FavoriteDF.DF_FAVORITE_SCREEN,
            methodName = DynamicFeaturePackageFactory.FavoriteDF.COMPOSE_METHOD_NAME
        )
    }
    @Composable
    fun ShowDFNotFoundScreen(detailNavigation: (String)->Unit) {
        DFNotFoundScreen(detailNavigation)
    }

    @Composable
    private fun loadDF(
        detailNavigation: (String)->Unit,
        className: String,
        methodName: String,
        objectInstance: Any = Any(),
    ): Boolean {
        val dfClass = loadClassByReflection(className)
        if (dfClass != null) {
            val composer = currentComposer
            val method = findMethodByReflection(
                dfClass,
                methodName
            )
            if (method != null) {
                val isMethodInvoked =
                    invokeMethod(method, objectInstance, detailNavigation, composer)
                if (!isMethodInvoked) {
                    ShowDFNotFoundScreen(detailNavigation)
                    return false
                }
                Log.d("Method invoked", "Screen 1")
                return true
            } else {
                ShowDFNotFoundScreen(detailNavigation)
                return false
            }
        } else {
            ShowDFNotFoundScreen(detailNavigation)
            return false
        }
    }


}