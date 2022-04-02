package com.twocoders.movies.network

import okhttp3.OkHttpClient
import org.koin.java.KoinJavaComponent
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * Rest client used for communication with the backend.
 */
object RestClient {

  private val httpClient: OkHttpClient by KoinJavaComponent.inject(OkHttpClient::class.java)
  private const val baseUrl: String = "https://api.themoviedb.org/3/"

  private val retrofit: Retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(baseUrl)
      .client(httpClient)
      .addConverterFactory(JacksonConverterFactory.create())
      .build()
  }

  /**
   * Creates an implementation of teh API endpoints defined by the [serviceClass] interface.
   *
   * @param serviceClass the REST interface
   */
  fun <T> createService(serviceClass: Class<T>): T {
    return retrofit.create(serviceClass)
  }
}