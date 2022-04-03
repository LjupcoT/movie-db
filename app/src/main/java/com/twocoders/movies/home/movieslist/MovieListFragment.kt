package com.twocoders.movies.home.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.twocoders.movies.R
import com.twocoders.movies.databinding.FragmentMoviesListBinding
import com.twocoders.movies.network.models.Resource
import com.twocoders.movies.utils.show
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A [Fragment] screen for displaying a list of movies.
 */
class MovieListFragment : Fragment() {

  private var binding: FragmentMoviesListBinding? = null
  private val views get() = binding!!

  private val viewModel: MoviesListViewModel by viewModel()

  private val moviesAdapter: MoviesListAdapter by lazy {
    MoviesListAdapter(
      mutableListOf(),
      onClick
    )
  }

  private val onClick: (movieId: Int) -> Unit = {
    val action = MovieListFragmentDirections.navToMovieDetails(it)
    Navigation.findNavController(views.root).navigate(action)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMoviesListBinding.inflate(inflater, container, false)

    views.moviesList.apply {
      this.adapter = moviesAdapter
      this.layoutManager = LinearLayoutManager(context)
      this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
    activity?.title = "Popular movies"
    initObservers()
    initListeners()
    viewModel.fetchPopularMovies()

    return views.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

  private fun initObservers() {
    viewModel.movies.observe(viewLifecycleOwner) { resource ->
      views.progressBar.show(resource.state == Resource.State.LOADING)
      if (resource.state == Resource.State.SUCCESS && resource.data != null) {
        moviesAdapter.updateMovieItems(resource.data.results.orEmpty())
      }
    }
    viewModel.page.observe(viewLifecycleOwner) { pageNumber ->
      views.paginationPrev.isEnabled = pageNumber > 1
      views.pageValue.text = pageNumber.toString()
    }
  }

  private fun initListeners() {
    views.paginationNext.setOnClickListener { viewModel.nextPage() }
    views.paginationPrev.setOnClickListener { viewModel.previousPage() }
  }
}
