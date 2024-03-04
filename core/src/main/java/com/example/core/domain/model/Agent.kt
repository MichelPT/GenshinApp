package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(
    val uuid:String,
    val displayName:String,
    val role:String,
    val description:String,
    val displayIcon:String,
    val fullPortrait:String,
    val isFavorite:Boolean
): Parcelable