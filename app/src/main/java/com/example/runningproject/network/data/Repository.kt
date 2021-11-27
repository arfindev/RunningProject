package com.example.runningproject.network.data

import com.example.runningproject.model.MovieData
import com.example.runningproject.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: ApiInterface) {
    fun getDataFromRepository(): Flow<List<MovieData>> = flow {
        emit(apiInterface.getMovieList())
    }.flowOn(Dispatchers.IO)

}