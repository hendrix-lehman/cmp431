@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nycparks.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nycparks.R
import com.example.nycparks.ui.screens.NycParksUIState
import com.example.nycparks.ui.screens.NycParksViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NycParksApp() {
  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
  ) {
    Surface(
      modifier = Modifier.fillMaxSize()
    ) {
      val nycParksViewModel: NycParksViewModel = viewModel(factory = NycParksViewModel.Factory)
      val nycParksUIState = nycParksViewModel.nycParksUIState
      when (nycParksUIState) {
        is NycParksUIState.Success -> println(nycParksUIState.nycParks)
        is NycParksUIState.Error -> println("Error")
        is NycParksUIState.Loading -> println("Loading")
      }
    }
  }
}

@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
    scrollBehavior = scrollBehavior, title = {
      Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.headlineSmall,
      )
    }, modifier = modifier
  )
}