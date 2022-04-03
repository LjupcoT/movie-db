package com.twocoders.movies.network

import com.twocoders.movies.network.interceptors.ConnectionInterceptor
import com.twocoders.movies.utils.ConnectionUtils
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
      addInterceptor(ConnectionInterceptor())
    }
}