package com.example.nycparks.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NycBorough(
  @StringRes val nameId: Int,
  @StringRes val yearSettledId: Int,
  @StringRes val interestingFactId: Int,
  @DrawableRes val flagId: Int,
  @DrawableRes val imageId: Int,
)

