package com.twocoders.movies.home.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.twocoders.movies.databinding.FragmentMovieDetailsBinding

/**
 * A [Fragment] screen for displaying details of a movie.
 */
class MovieDetailsFragment : Fragment() {

  private var binding: FragmentMovieDetailsBinding? = null
  private val views get() = binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
    return views.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}
