package com.example.core.data

import android.util.Log
import com.example.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                saveCallResult(apiResponse.data)
                emitAll(loadFromDB().map { Resource.Success(it) })
                Log.d("Success", "ApiResponse Success")
            }

            is ApiResponse.Empty -> {
                emitAll(loadFromDB().map { Resource.Success(it) })
            }

            is ApiResponse.Error -> {
                onFetchFailed()
                emit(Resource.Error(apiResponse.errorMessage))
                Log.d("Error", "ApiResponse Error. ${apiResponse.errorMessage}")
            }

        }

    }

    private fun onFetchFailed() {
        Log.d(TAG, "onFetchFailed")
    }


    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result

    companion object {
        const val TAG = "NetworkBoundResource"
    }
}