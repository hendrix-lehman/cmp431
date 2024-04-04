package com.example.nycparks.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.nycparks.model.NycBorough

@Composable
fun HomeScreen(
  nycParksUIState: NycParksUIState,
  retryAction: () -> Unit,
  contentPadding: PaddingValues = PaddingValues(0.dp),
) {

  when (nycParksUIState) {
    is NycParksUIState.Loading -> println("Loading")
    is NycParksUIState.Success<*> -> NycBoroughList(
      nycParksUIState.data as List<NycBorough>,
      Modifier
        .fillMaxSize()
        .padding(contentPadding)
    )

    is NycParksUIState.Error -> println("Error")
    else -> println("ready")
  }
}

@Composable
fun NycBoroughList(
  boroughs: List<NycBorough>,
  modifier: Modifier = Modifier,
) {
  LazyColumn(
  ) {
    items(boroughs) { borough ->
      NycBoroughCard(borough = borough, modifier)
    }
  }

}

@Composable
fun NycBoroughCard(
  borough: NycBorough,
  modifier: Modifier = Modifier,
) {
  Card(
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surfaceVariant
    ),
  ) {
    Column(
    ) {
      Image(
        painter = painterResource(id = borough.flagId),
        contentDescription = stringResource(id = borough.nameId),
        modifier = modifier
          .fillMaxWidth()
          .height(194.dp),
      )
      Text(
        text = LocalContext.current.getString(borough.nameId),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        style = MaterialTheme.typography.headlineSmall
      )
      Text(
        text = LocalContext.current.getString(borough.yearSettledId),
        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, end = 16.dp),
        style = MaterialTheme.typography.labelSmall,
      )
      Text(
        text = LocalContext.current.getString(borough.interestingFactId),
        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
        style = MaterialTheme.typography.labelSmall,
      )

    }
  }
}

//@Composable
//fun NycBoroughParksCard(
//  borough: Borough,
//  modifier: Modifier = Modifier,
//) {
//  Column {
//    Image(
//      painter = painterResource(id = borough.imageId),
//      contentDescription = stringResource(id = borough.nameId),
//      modifier = modifier
//        .fillMaxWidth()
//        .height(96.dp),
//      contentScale = ContentScale.Crop,
//    )
//    Text(
//      text = LocalContext.current.getString(borough.nameId),
//      modifier = Modifier.padding(8.dp),
//      style = MaterialTheme.typography.titleSmall
//    )
//  }
//}

//@Preview
//@Composable
//private fun NycBoroughParksCardPreview() {
//  NycBoroughParksCard(
//    borough = Borough(
//      R.string.manhattan,
//      R.string.manhattan_settled_year,
//      R.string.manhattan_interesting_fact,
//      R.drawable.flag_of_the_borough_of_manhattan_svg,
//      R.drawable.manhattan_skyline
//    )
//  )
//}

//@Preview
//@Composable
//private fun NycBoroughCardPreview() {
//  NycBoroughCard(
//    borough = Borough(
//      R.string.manhattan,
//      R.string.manhattan_settled_year,
//      R.string.manhattan_interesting_fact,
//      R.drawable.flag_of_the_borough_of_manhattan_svg,
//      R.drawable.manhattan_skyline
//    )
//  )
//}