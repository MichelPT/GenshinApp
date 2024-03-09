package com.example.genshinapp.ui.utilities

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.genshinapp.ui.utilities.DynamicFeatureUtils

@Composable
fun FavoriteDF(detailNavigation: (String)->Unit) {
    DynamicFeatureUtils.dfFavorite(detailNavigation)
}

//@Composable
//fun DFSecondScreen(paddingValues: PaddingValues, text:String) {
//    DynamicFeatureUtils.dfSecondScreen(paddingValues, text)
//}
//
//@Composable
//fun DFThirdScreen(paddingValues: PaddingValues, text:String) {
//    DynamicFeatureUtils.dfThirdScreen(paddingValues, text)
//}