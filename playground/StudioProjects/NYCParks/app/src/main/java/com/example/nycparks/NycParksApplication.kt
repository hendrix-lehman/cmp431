package com.example.nycparks

import android.app.Application
import com.example.nycparks.data.AppContainer
import com.example.nycparks.data.DefaultAppContainer

class NycParksApplication : Application() {
  lateinit var container: AppContainer

  override fun onCreate() {
    super.onCreate()
    container = DefaultAppContainer()
  }
}