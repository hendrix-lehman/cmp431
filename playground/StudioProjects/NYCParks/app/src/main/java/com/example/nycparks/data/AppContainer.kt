package com.example.nycparks.data

import com.example.nycparks.network.NycOpenDataApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
  val nycParksRepository: NycParksRepository
}

class DefaultAppContainer : AppContainer {

  private val baseUrl = "https://nycopendata.socrata.com/resource/"

  /**
   * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
   */
  private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(
      Json {
        ignoreUnknownKeys = true
      }
        .asConverterFactory("application/json".toMediaType())
    )
    .baseUrl(baseUrl)
    .build()

  /**
   * Retrofit service object for creating api calls
   */
  private val retrofitService: NycOpenDataApiService by lazy {
    retrofit.create(NycOpenDataApiService::class.java)
  }

  /**
   * DI implementation for NYC Parks repository
   */
  override val nycParksRepository: NycParksRepository by lazy {
    NetworkNycParksRepository(retrofitService)
  }
}