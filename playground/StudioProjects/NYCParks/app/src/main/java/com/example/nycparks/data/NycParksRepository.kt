package com.example.nycparks.data

import com.example.nycparks.R
import com.example.nycparks.model.NycBorough
import com.example.nycparks.model.NycPark
import com.example.nycparks.network.NycOpenDataApiService

interface NycParksRepository {
  suspend fun getNycParks(): List<NycPark>
  suspend fun getNycBoroughs(): List<NycBorough>
}

enum class BoroughCode(val code: Char) {
  MANHATTAN('M'), BRONX('X'), QUEENS('Q'), BROOKLYN('B'), STATEN_ISLAND('R')
}

class NetworkNycParksRepository(
  private val nycOpenDataApiService: NycOpenDataApiService,
) : NycParksRepository {
  override suspend fun getNycParks(): List<NycPark> = nycOpenDataApiService.getNycParks()

  override suspend fun getNycBoroughs(): List<NycBorough> = listOf(
//    Borough(
//      R.string.favorites,
//      R.string.count,
//      R.string.boroughs_interesting_fact,
//      R.drawable.nyc_boroughs_flag,
//      R.drawable.nyc_borough_map,
//    ),
    NycBorough(
      R.string.manhattan,
      R.string.manhattan_settled_year,
      R.string.manhattan_interesting_fact,
      R.drawable.flag_of_the_borough_of_manhattan_svg,
      R.drawable.manhattan_skyline,
    ), NycBorough(
      R.string.bronx,
      R.string.bronx_settled_year,
      R.string.bronx_interesting_fact,
      R.drawable.flag_of_borough_of_the_bronx_svg,
      R.drawable.bronx_zoo,
    ), NycBorough(
      R.string.queens,
      R.string.queens_settled_year,
      R.string.queens_interesting_fact,
      R.drawable.flag_of_queens__new_york_svg,
      R.drawable.queens_unisphere,
    ), NycBorough(
      R.string.brooklyn,
      R.string.brooklyn_settled_year,
      R.string.brooklyn_interesting_fact,
      R.drawable.flag_of_brooklyn__new_york_svg,
      R.drawable.brooklyn_bridge,
    ), NycBorough(
      R.string.staten_island,
      R.string.staten_island_settled_year,
      R.string.staten_island_interesting_fact,
      R.drawable.flag_of_the_borough_of_staten_island_svg,
      R.drawable.staten_island_ferry,
    )
  )
}