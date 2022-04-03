package com.twocoders.movies.home.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.twocoders.movies.databinding.FragmentMoviesListBinding

/**
 * A [Fragment] screen for displaying a list of movies.
 */
class MovieListFragment : Fragment() {

  private var binding: FragmentMoviesListBinding? = null
  private val views get() = binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMoviesListBinding.inflate(inflater, container, false)
    return views.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}
