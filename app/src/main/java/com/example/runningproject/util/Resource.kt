package com.example.runningproject.util

import com.example.runningproject.model.MovieData

sealed class Resource{
    class Success(val data:List<MovieData>) : Resource()
    class Failure(val msg:Throwable) : Resource()
    object Loading : Resource()
    object Empty: Resource()
}
