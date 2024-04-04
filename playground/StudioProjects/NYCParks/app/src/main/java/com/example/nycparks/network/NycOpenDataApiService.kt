package com.example.nycparks.network

import com.example.nycparks.model.NycPark
import retrofit2.http.GET

interface NycOpenDataApiService {

  @GET("enfh-gkve.json")
  suspend fun getNycParks(): List<NycPark>
}