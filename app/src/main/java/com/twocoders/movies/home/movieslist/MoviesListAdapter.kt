package com.twocoders.movies.home.movieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.twocoders.movies.databinding.ItemMovieLayoutBinding
import com.twocoders.movies.network.models.MovieListItemModel
import com.twocoders.movies.utils.loadImageFromPath

/**
 * Represents a [RecyclerView.ViewHolder] for a list of [MovieListItemModel]s.
 */
class MoviesListAdapter(
  private val movies: MutableList<MovieListItemModel>,
  private val onClick: (movieId: Int) -> Unit
) : RecyclerView.Adapter<MoviesListAdapter.MovieItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListAdapter.MovieItemViewHolder {
    val view = ItemMovieLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return MovieItemViewHolder(view)
  }

  override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
    holder.bind(movies[position])
  }

  override fun getItemCount() = movies.size

  /**
   * Updates the list of movie items.
   *
   * @param newMovies [List] of [MovieListItemModel]
   */
  fun updateMovieItems(newMovies: List<MovieListItemModel>) {
    this.movies.apply {
      clear()
      addAll(newMovies)
    }
    notifyDataSetChanged()
  }

  /**
   * Represents a [RecyclerView.ViewHolder] for a movie item.
   */
  inner class MovieItemViewHolder(
    private val views: ItemMovieLayoutBinding
  ) : RecyclerView.ViewHolder(views.root) {

    /**
     * Bind content to UI.
     */
    fun bind(movie: MovieListItemModel) {
      views.root.setOnClickListener { movie.id?.let { id -> onClick(id) } }
      views.movieTitle.text = movie.title
      views.movieDescription.text = movie.overview
      movie.posterPath?.let { views.moviePosterView.loadImageFromPath(it) }
    }
  }
}