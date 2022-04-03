package com.twocoders.movies.network.interceptors

import com.twocoders.movies.errorhandling.exceptions.NoConnectionException
import com.twocoders.movies.utils.ConnectionUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * [Interceptor] that checks if the device has connection before proceeding with the network call.
 * Throws a [NoConnectionException] if device is not connected.
 */
class ConnectionInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    if (!ConnectionUtils.hasConnection()) {
      throw NoConnectionException()
    }
    return chain.proceed(chain.request())
  }
}