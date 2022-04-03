package com.twocoders.movies.home.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twocoders.movies.home.service.MoviesService
import com.twocoders.movies.network.models.PopularMoviesResponse
import com.twocoders.movies.network.models.Resource
import kotlinx.coroutines.launch

/**
 * [ViewModel] for the [MovieListFragment].
 */
class MoviesListViewModel(
  private val service: MoviesService
) : ViewModel() {

  private val _movies = MutableLiveData<Resource<PopularMoviesResponse>>()
  val movies: LiveData<Resource<PopularMoviesResponse>> = _movies

  private val _page = MutableLiveData(1)
  val page: LiveData<Int> = _page

  /**
   * Fetches the list of popular movies.
   */
  fun fetchPopularMovies() = viewModelScope.launch {
    _movies.value = Resource.loading()
    _movies.value = service.getPopularMovies(page.value ?: 1)
  }

  /**
   * Sends a request to fetch the next page of the popular movies list.
   */
  fun nextPage() = viewModelScope.launch {
    _movies.value = Resource.loading()
    _page.value = _page.value?.inc()
    _movies.value = service.getPopularMovies(page = page.value ?: 1)
  }

  /**
   * Sends a request to fetch the previous page of the popular movies list.
   */
  fun previousPage() = viewModelScope.launch {
    _movies.value = Resource.loading()
    _page.value = _page.value?.dec()
    _movies.value = service.getPopularMovies(page = page.value ?: 1)
  }
}