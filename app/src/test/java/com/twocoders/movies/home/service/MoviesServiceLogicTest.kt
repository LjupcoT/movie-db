package com.twocoders.movies.home.service

import com.twocoders.movies.home.movieDetails
import com.twocoders.movies.home.moviesResponseSuccessful
import com.twocoders.movies.network.apis.MoviesDbRestApi
import com.twocoders.movies.network.models.Resource
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class MoviesServiceLogicTest {

  @Mock
  private lateinit var api: MoviesDbRestApi

  private lateinit var service: MoviesServiceLogic

  @Before
  fun setup() {
    MockitoAnnotations.openMocks(this)
    service = MoviesServiceLogic(api)
  }

  @Test
  fun `retrieve popular movies successfully`() = runBlocking {
    // Given
    `when`(api.getPopularMovies(1)).thenReturn(Response.success(moviesResponseSuccessful))
    // When
    val result = service.getPopularMovies()

    // Then
    assertEquals(Resource.State.SUCCESS, result.state)
    assertNotNull(result.data)
    assertNull(result.error)
    assertEquals(moviesResponseSuccessful.results?.size, result.data?.results?.size)
    assertEquals(moviesResponseSuccessful.page, result.data?.page)
    assertEquals(moviesResponseSuccessful.totalPages, result.data?.totalPages)
    assertEquals(moviesResponseSuccessful.totalResults, result.data?.totalResults)
  }

  @Test
  fun `retrieve popular movies successful but empty data`() = runBlocking {
    // Given
    `when`(api.getPopularMovies(1))
      .thenReturn(Response.success(moviesResponseSuccessful.copy(results = null)))
    // When
    val result = service.getPopularMovies()

    // Then
    assertEquals(Resource.State.SUCCESS, result.state)
    assertNotNull(result.data)
    assertNull(result.error)
    assertNull(result.data?.results)
    assertEquals(moviesResponseSuccessful.page, result.data?.page)
    assertEquals(moviesResponseSuccessful.totalPages, result.data?.totalPages)
    assertEquals(moviesResponseSuccessful.totalResults, result.data?.totalResults)
  }

  @Test
  fun `retrieve popular movies error response`() = runBlocking {
    // Given
    val expectedErrorCode = 999
    `when`(api.getPopularMovies(1))
      .thenReturn(Response.error(expectedErrorCode, "".toResponseBody()))
    // When
    val result = service.getPopularMovies()

    // Then
    assertEquals(Resource.State.ERROR, result.state)
    assertNull(result.data)
    assertNotNull(result.error)
    assertEquals(expectedErrorCode, result.error?.code)
  }

  @Test
  fun `retrieve popular movies exception occurs`() = runBlocking {
    // Given
    `when`(api.getPopularMovies(1))
      .thenThrow(RuntimeException())
    // When
    val result = service.getPopularMovies()

    // Then
    assertEquals(Resource.State.ERROR, result.state)
    assertNull(result.data)
    assertNotNull(result.error)
    assertEquals(-1, result.error?.code)
  }

  @Test
  fun `retrieve movie details successfully`() = runBlocking {
    // Given
    val movieId = 123
    `when`(api.getMovieDetails(movieId))
      .thenReturn(Response.success(movieDetails))
    // When
    val result = service.getMovieDetails(movieId)

    // Then
    assertEquals(Resource.State.SUCCESS, result.state)
    assertNotNull(result.data)
    assertNull(result.error)
    assertEquals(movieDetails, result.data)
  }

  @Test
  fun `retrieve movie details error response`() = runBlocking {
    // Given
  val movieId = 123
  val expectedErrorCode = 999
    `when`(api.getMovieDetails(movieId))
      .thenReturn(Response.error(expectedErrorCode, "".toResponseBody()))
    // When
    val result = service.getMovieDetails(movieId)

    // Then
    assertEquals(Resource.State.ERROR, result.state)
    assertNull(result.data)
    assertNotNull(result.error)
    assertEquals(expectedErrorCode, result.error?.code)
  }

  @Test
  fun `retrieve movie details exception occurs`() = runBlocking {
    // Given
  val movieId = 123
  `when`(api.getMovieDetails(movieId))
      .thenThrow(RuntimeException())
    // When
    val result = service.getMovieDetails(movieId)

    // Then
    assertEquals(Resource.State.ERROR, result.state)
    assertNull(result.data)
    assertNotNull(result.error)
    assertEquals(-1, result.error?.code)
  }
}