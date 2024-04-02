package com.example.nycparks.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.nycparks.NycParksApplication
import com.example.nycparks.data.NycParksRepository
import com.example.nycparks.model.NycPark
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface NycParksUIState {
  data class Success(val nycParks: List<NycPark>) : NycParksUIState
  object Error : NycParksUIState
  object Loading : NycParksUIState
}

class NycParksViewModel(private val nycParksRepository: NycParksRepository) : ViewModel() {

  var nycParksUIState: NycParksUIState by mutableStateOf(NycParksUIState.Loading)
    private set

  init {
    getNycParks()
  }

  fun getNycParks() {
    viewModelScope.launch {
      nycParksUIState = NycParksUIState.Loading
      nycParksUIState = try {
        NycParksUIState.Success(nycParksRepository.getNycParks())
      } catch (e: IOException) {
        println(e.stackTraceToString())
        NycParksUIState.Error
      } catch (e: HttpException) {
        println(e.stackTraceToString())
        NycParksUIState.Error
      }
    }
  }

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[APPLICATION_KEY] as NycParksApplication)
        val nycParksRepository = application.container.nycParksRepository
        NycParksViewModel(nycParksRepository = nycParksRepository)
      }
    }
  }
}