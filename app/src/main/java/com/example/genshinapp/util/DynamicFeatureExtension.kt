package com.example.genshinapp.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DFFavorite(
    modifier: Modifier = Modifier,
    detailNavigation: (String) -> Unit,
){
    DynamicFeatureUtils.favoriteDynamicFeature(detailNavigation = detailNavigation, modifier = modifier)
}