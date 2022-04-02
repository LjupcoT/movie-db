package com.twocoders.movies

import android.app.Application
import com.twocoders.movies.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Base [Application] class.
 */
class App : Application() {

  companion object {
    lateinit var instance: App
      private set
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    setupKoin()
  }

  private fun setupKoin() {
    startKoin {
      androidContext(this@App)
      modules(appModule)
    }
  }
}