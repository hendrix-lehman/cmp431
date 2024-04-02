package com.example.nycparks.model

import kotlinx.serialization.Serializable

@Serializable
data class NycPark(
//  @SerialName(value = "signname")
  val signname: String? = "",
  val url: String? = "",
  var address: String? = "",
  val borough: Char,
  val zipcode: String,
  val location: String? = "",
  val permit: Boolean = false,
  val retired: Boolean = false,
  val waterfront: Boolean = false,
)
