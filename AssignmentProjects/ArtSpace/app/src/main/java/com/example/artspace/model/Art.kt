package com.example.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Art(
  @StringRes val artistId: Int,
  @StringRes val artistInfoId: Int,
  @StringRes val titleId: Int,
  @StringRes val yearId: Int,
  @StringRes val descriptionId: Int,
  @StringRes val artistBioId: Int,
  @DrawableRes val artworkImageId: Int,
  @DrawableRes val artistImageId: Int,
)
