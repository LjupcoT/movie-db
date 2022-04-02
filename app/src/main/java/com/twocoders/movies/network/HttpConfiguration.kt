package com.twocoders.movies.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Handles the HTTP configurations.
 */
object HttpConfiguration {

  internal fun getHttpBuilder() =
    OkHttpClient.Builder().apply {
      readTimeout(60, TimeUnit.SECONDS)
      connectTimeout(60, TimeUnit.SECONDS)
    }
}