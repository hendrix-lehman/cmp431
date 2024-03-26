package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.artspace.data.DataSource
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      ArtSpaceTheme {
        NavHost(
          navController = navController, startDestination = Screen.Home.route + "/{id}"
        ) {
          composable(
            Screen.Home.route + "/{id}", arguments = listOf(navArgument("id") {
              type = NavType.IntType
              defaultValue = 0
            })
          ) {
            HomePage(navController)
          }
          composable(
            Screen.Artist.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
          ) {
            ArtistPage(navController)
          }
        }
      }
    }
  }
}

@Composable
fun ArtistProfile(imageId: Int, nameId: Int, infoId: Int) {
  Column {
    Image(
      modifier = Modifier
        .clip(CircleShape)
        .size(24.dp),
      contentScale = ContentScale.Crop,
      painter = painterResource(id = imageId),
      contentDescription = stringResource(id = nameId)
    )

  }
  Text(text = stringResource(id = nameId))
  Text(text = stringResource(id = infoId))
}

@Composable
fun ArtistBio(artistBio: Int) {
  Column {
    Text(
      text = stringResource(id = artistBio), fontSize = 10.sp, modifier = Modifier
        .padding(40.dp)
        .align(alignment = Alignment.Start)
    )
  }

}


@Composable
fun ArtistPage(navController: NavController) {
  val id = navController.currentBackStackEntry?.arguments?.getInt("id") ?: 0
  val art = DataSource.arts[id]

  // ARTIST PAGE section A
  // TODO: 1. Artist Profile including image, name, and info (birthplace, and years alive)
  ArtistProfile(imageId = art.artistImageId, nameId = art.artistId, infoId = art.artistInfoId)
  // ARTIST PAGE section B
  // TODO: 2  Artist bio
  ArtistBio(artistBio = art.artistBioId)

  // <--- Safely REMOVE the following code and ADD your code here --->
//  Text(text = "(D) Display Artist Profile and Bio here as per the design")

  // DO NOT MODIFY THE FOLLOWING CODE
  // You can use the following code to navigate to the previous screen:
  // ARTIST PAGE section C
  // TODO: 3 place the code below in the proper Row or Column layout
  Column(modifier = Modifier, verticalArrangement = Arrangement.Bottom) {
    Button(onClick = {
      navController.navigate(Screen.Home.route + "/$id")
    }) {
      Text(text = stringResource(id = R.string.back))
    }
  }
}


@Composable
fun ArtWall(
  artistId: Int,
  artImageId: Int,
  artDescriptionId: Int,
  navController: NavController,
) {

  // HOME PAGE section A

  // TODO: 4. Add image of artwork
  // var artResult by remember{(mutableStateOf(1))}

  var artResult by remember { (mutableStateOf(1)) }
  val artImageResource = when (artResult) {
    1 -> R.drawable.art_1_the_starry_night
    2 -> R.drawable.art_2_pool_room
    3 -> R.drawable.art_3_new_york_street_scene
    4 -> R.drawable.art_4_girl_with_a_pearl_earing
    5 -> R.drawable.art_5_mona_lisa

    else -> R.drawable.art_1_the_starry_night
  }

  //Image(painter = painterResource(id = artImageResource), contentDescription =artResult.toString() )


  // TODO: 5. Add a click listener to navigate to the artist page
  // to navigate to the artist page, use the following code:
  // navController.navigate(Screen.Artist.route + "/$artistId")
  // see example below.

  // <--- Safely REMOVE the following code and ADD your code here --->
  Box(modifier = Modifier.clickable {
    navController.navigate(Screen.Artist.route + "/$artistId")
  }) {
    //Text(text = "(A) Display Artwork Image here as per the design" + artImageResource)
    Image(
      painter = painterResource(id = artImageResource),
      contentDescription = artResult.toString()
    )

  }
}

@Composable
fun ArtDescriptor(artTitleId: Int, artistId: Int, artYearId: Int) {

  // HOME PAGE section B

  // TODO: 6. Add title of artwork
  Row {
    Text(
      text = stringResource(id = artTitleId), fontWeight = FontWeight.Bold,
      fontSize = 19.sp,
      modifier = Modifier
        .padding(10.dp)
        .align(alignment = Alignment.CenterVertically)
    )
  }
  // TODO: 7. Add artist name and year of artwork
  Row {
    Text(
      text = stringResource(id = artistId),
      fontSize = 17.sp,
      modifier = Modifier
        .padding(10.dp)
        .align(alignment = Alignment.CenterVertically)
    )
    Text(
      text = stringResource(id = artYearId),
      fontSize = 17.sp,
      modifier = Modifier
        .padding(10.dp)
        .align(alignment = Alignment.CenterVertically)
    )
  }

  // <--- Safely REMOVE the following code and ADD your code here --->
  // Text(text = "(B) Display Artwork Title, Artist Name and Year here as per the design")
}


@Composable
fun DisplayController(current: Int, move: (Int) -> Unit) {

  // HOME PAGE section C

  // TODO: 9. Add a button to navigate to the previous artwork

  if (current != 0) {
    Column {
      Button(onClick = { current }) {

        Text(stringResource(id = R.string.previous))
        move(current - 1)

      }

    }
  }


  // TODO: 10. Add a button to navigate to the next artwork
  if (current <= 5) {
    Column(modifier = Modifier, horizontalAlignment = Alignment.Start) {
      Button(onClick = { current }) {

        Text(stringResource(id = R.string.next))
        move(current + 1)


      }
    }
  }


  // NOTE:
  // The buttons should be disabled if there is no previous or next artwork to navigate to
  // You can use the following code to disable the button:
  //  enabled = current != 0 // for the previous button

  // You can use the following code to navigate to the previous or next artwork:
  // move(current - 1) // for the previous button
  // move(current + 1) // for the next button

  // <--- Safely REMOVE the following code and ADD your code here --->
  // Text(text = "(C) Display buttons to navigate to the previous and next artwork here as per the design")

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
  var current by remember {
    mutableIntStateOf(
      navController.currentBackStackEntry?.arguments?.getInt(
        "id"
      ) ?: 0
    )
  }
  val art = DataSource.arts[current]

  Scaffold(topBar = {
    CenterAlignedTopAppBar(
      title = { Text(text = stringResource(id = R.string.app_name)) },
      colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
      )
    )
  }) { innerPadding ->
    /**
     *The children without weight (a) are measured first. After that, the remaining space in the column
     * is spread among the children with weights (b), proportional to their weight. If you have 2
     * children with weight 1f, each will take half the remaining space.
     */
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(innerPadding)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f) // children with weight (b)
      ) {

        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacer_extra_large)))
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.Center,
        ) {
          ArtWall(current, art.artworkImageId, art.descriptionId, navController)
        }
      }
      // (a) children without weight
      ArtDescriptor(art.titleId, art.artistId, art.yearId)
      DisplayController(current) {
        current = if (it !in 0..<DataSource.arts.size) 0 else it
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
  ArtSpaceTheme {
    HomePage(rememberNavController())
  }
}