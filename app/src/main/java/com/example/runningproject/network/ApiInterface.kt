package com.example.runningproject.network

import com.example.runningproject.model.MovieData
import retrofit2.http.GET

interface ApiInterface {

    @GET("movielist.json")
    suspend fun getMovieList(): List<MovieData>
}