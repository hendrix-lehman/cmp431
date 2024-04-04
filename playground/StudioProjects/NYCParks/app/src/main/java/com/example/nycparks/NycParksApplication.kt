package com.example.nycparks

import android.app.Application
import android.util.Log
import com.example.nycparks.data.AppContainer
import com.example.nycparks.data.DefaultAppContainer
import com.example.nycparks.util.TAG

class NycParksApplication : Application() {
  lateinit var container: AppContainer

  override fun onCreate() {
    Log.i(TAG, "Application: creating DefaultAppContainer")
    super.onCreate()
    container = DefaultAppContainer()
  }

}