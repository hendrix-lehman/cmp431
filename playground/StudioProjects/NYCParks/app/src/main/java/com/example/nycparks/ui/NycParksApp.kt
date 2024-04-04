@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nycparks.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nycparks.R
import com.example.nycparks.ui.screens.HomeScreen
import com.example.nycparks.ui.screens.NycParksViewModel

@Composable
fun NycParksApp() {
  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//  Scaffold(
//    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//    topBar = { AppTopAppBar(scrollBehavior = scrollBehavior) }
//  ) {
//    Surface(
//      modifier = Modifier.fillMaxSize()
//    ) {
  val nycParksViewModel: NycParksViewModel = viewModel(factory = NycParksViewModel.Factory)
  HomeScreen(
    nycParksViewModel.nycParksUIState,
    nycParksViewModel::getNycParks,
//      contentPadding = it,
  )
//    }
//}
}

@Composable
fun AppTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
//    scrollBehavior = scrollBehavior,
    title = {
      Text(
        text = stringResource(R.string.boroughs_title),
        style = MaterialTheme.typography.headlineSmall,
      )
    },
    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    modifier = modifier,
  )
}