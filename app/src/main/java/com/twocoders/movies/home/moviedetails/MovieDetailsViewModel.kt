package com.twocoders.movies.home.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twocoders.movies.home.service.MoviesService
import com.twocoders.movies.network.models.MovieDetails
import com.twocoders.movies.network.models.Resource
import kotlinx.coroutines.launch

/**
 * [ViewModel] for the [MovieDetailsFragment].
 */
class MovieDetailsViewModel(
  private val service: MoviesService
) : ViewModel() {

  private val _movieDetails = MutableLiveData<Resource<MovieDetails>>()
  val movieDetails: LiveData<Resource<MovieDetails>> = _movieDetails

  /**
   * Fetches the complete movie details for the provided ID.
   *
   * @param movieId [Int]
   */
  fun fetchMovieDetails(movieId: Int) = viewModelScope.launch {
    _movieDetails.value = Resource.loading()
    _movieDetails.value = service.getMovieDetails(movieId)
  }
}