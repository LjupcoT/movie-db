package com.twocoders.movies.home.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.twocoders.movies.databinding.FragmentMovieDetailsBinding
import com.twocoders.movies.network.models.MovieDetails
import com.twocoders.movies.network.models.Resource
import com.twocoders.movies.utils.loadImageFromPath
import com.twocoders.movies.utils.show
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A [Fragment] screen for displaying details of a movie.
 */
class MovieDetailsFragment : Fragment() {

  private var binding: FragmentMovieDetailsBinding? = null
  private val views get() = binding!!
  private val args: MovieDetailsFragmentArgs by navArgs()
  private val viewModel: MovieDetailsViewModel by viewModel()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
    viewModel.fetchMovieDetails(args.movieId)
    initObservers()
    return views.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

  private fun initObservers() {
    viewModel.movieDetails.observe(viewLifecycleOwner) { resource ->
      views.progressBar.show(resource.state == Resource.State.LOADING)
      if (resource.state == Resource.State.SUCCESS && resource.data != null) {
        handleResponse(resource.data)
      }
    }
  }

  private fun handleResponse(movieDetails: MovieDetails) {
    views.movie = movieDetails
    activity?.title = movieDetails.title
    movieDetails.genres?.let { genres ->
      views.movieGenres.text = genres.joinToString(separator = ", ") { it.name.orEmpty() }
    }
    movieDetails.posterPath?.let { views.moviePosterView.loadImageFromPath(it) }
    views.productionCompaniesList.adapter =
      ProductionCompaniesAdapter(movieDetails.productionCompanies.orEmpty())
  }
}
