package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AgentResponse(

    @field:SerializedName("killfeedPortrait")
    val killfeedPortrait: String? = null,

    @field:SerializedName("role")
    val role: Role? = null,

    @field:SerializedName("isFullPortraitRightFacing")
    val isFullPortraitRightFacing: Boolean? = null,

    @field:SerializedName("displayName")
    val displayName: String? = null,

    @field:SerializedName("isBaseContent")
    val isBaseContent: Boolean? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("backgroundGradientColors")
    val backgroundGradientColors: List<String?>? = null,

    @field:SerializedName("isAvailableForTest")
    val isAvailableForTest: Boolean? = null,

    @field:SerializedName("uuid")
    val uuid: String? = null,

    @field:SerializedName("characterTags")
    val characterTags: Any? = null,

    @field:SerializedName("displayIconSmall")
    val displayIconSmall: String? = null,

    @field:SerializedName("fullPortrait")
    val fullPortrait: String? = null,

    @field:SerializedName("fullPortraitV2")
    val fullPortraitV2: String? = null,

    @field:SerializedName("abilities")
    val abilities: List<AbilitiesItem?>? = null,

    @field:SerializedName("displayIcon")
    val displayIcon: String? = null,

    @field:SerializedName("recruitmentData")
    val recruitmentData: Any? = null,

    @field:SerializedName("bustPortrait")
    val bustPortrait: String? = null,

    @field:SerializedName("background")
    val background: String? = null,

    @field:SerializedName("assetPath")
    val assetPath: String? = null,

    @field:SerializedName("voiceLine")
    val voiceLine: Any? = null,

    @field:SerializedName("isPlayableCharacter")
    val isPlayableCharacter: Boolean? = null,

    @field:SerializedName("developerName")
    val developerName: String? = null
)

data class AbilitiesItem(

    @field:SerializedName("displayIcon")
    val displayIcon: String? = null,

    @field:SerializedName("displayName")
    val displayName: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("slot")
    val slot: String? = null
)

data class Role(

    @field:SerializedName("displayIcon")
    val displayIcon: String? = null,

    @field:SerializedName("displayName")
    val displayName: String? = null,

    @field:SerializedName("assetPath")
    val assetPath: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("uuid")
    val uuid: String? = null
)



