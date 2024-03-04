package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agent")
data class AgentEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    val uuid: String,

    @ColumnInfo(name = "displayName")
    val displayName: String,

    @ColumnInfo("description")
    val description: String,

    @ColumnInfo("role")
    val role: String,

    @ColumnInfo("displayIcon")
    val displayIcon: String,

    @ColumnInfo("fullPortrait")
    val fullPortrait: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,
)