package com.example.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.core.data.source.local.entity.AgentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {
    @Query("SELECT * FROM agent")
    fun getAllAgents():Flow<List<AgentEntity>>

    @Query("SELECT * FROM agent WHERE isFavorite = 1")
    fun getFavoriteAgent():Flow<List<AgentEntity>>

    @Query("SELECT * FROM agent WHERE uuid=:uuid")
    fun getAgentDetails(uuid:String):Flow<AgentEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAgent(agent: List<AgentEntity>)

    @Update
    fun updateFavoriteAgent(agent: AgentEntity)
}