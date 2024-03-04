package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListAgentsResponse(

    @field:SerializedName("data")
	val data: List<AgentResponse>,

    @field:SerializedName("status")
	val status: Int
)


