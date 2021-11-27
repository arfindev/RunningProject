package com.example.runningproject.network.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runningproject.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val response: MutableState<Resource> = mutableStateOf(Resource.Empty)

    init {
        getDataFromViewModel()
    }


    fun getDataFromViewModel() = viewModelScope.launch {
        repository.getDataFromRepository().onStart {
            response.value = Resource.Loading
        }.catch {
            response.value = Resource.Failure(it)


        }.collect {
            response.value = Resource.Success(it)

        }
    }

}