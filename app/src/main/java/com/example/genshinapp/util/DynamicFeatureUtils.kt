package com.example.genshinapp.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Modifier
import com.example.genshinapp.ui.components.DFNotFoundScreen
import com.example.genshinapp.ui.factory.DynamicFeaturePackageFactory

object DynamicFeatureUtils {
    @Composable
    fun favoriteDynamicFeature(
        modifier: Modifier = Modifier,
        detailNavigation: (String) -> Unit,
    ): Boolean {
        return loadDF(
            modifier = modifier,
            detailNavigation = detailNavigation,
            className = DynamicFeaturePackageFactory.FavoriteDF.DF_FAVORITE_SCREEN,
            methodName = DynamicFeaturePackageFactory.FavoriteDF.COMPOSE_METHOD_NAME
        )
    }

    @Composable
    fun ShowDFNotFoundScreen(
        modifier: Modifier = Modifier,
        detailNavigation: (String) -> Unit,
    ) {
        DFNotFoundScreen(modifier, detailNavigation)
    }

    @Composable
    private fun loadDF(
        modifier: Modifier,
        detailNavigation: (String) -> Unit,
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
                    invokeMethod(method, objectInstance, modifier, detailNavigation, composer, 0)
                if (!isMethodInvoked) {
                    ShowDFNotFoundScreen(modifier, detailNavigation)
                    return false
                }
                return true
            } else {
                ShowDFNotFoundScreen(modifier, detailNavigation)
                return false
            }
        } else {
            ShowDFNotFoundScreen(modifier, detailNavigation)
            return false
        }
    }


}