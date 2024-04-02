package com.example.nycparks.data

import com.example.nycparks.model.NycPark
import com.example.nycparks.network.NycOpenDataApiService

interface NycParksRepository {

  suspend fun getNycParks(): List<NycPark>
}

class NetworkNycParksRepository(
  private val nycOpenDataApiService: NycOpenDataApiService,
) : NycParksRepository {
  override suspend fun getNycParks(): List<NycPark> = nycOpenDataApiService.getNycParks()
}