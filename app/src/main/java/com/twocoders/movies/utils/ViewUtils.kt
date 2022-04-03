package com.twocoders.movies.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Sets [View] visibility to [View.VISIBLE] or [View.GONE] according the passed parameter
 *
 * @param shouldShow [Boolean]
 */
fun View.show(shouldShow: Boolean) {
  visibility = if (shouldShow) View.VISIBLE else View.GONE
}

/**
 * Loads an image found on the path provided as parameter.
 *
 * @param posterPath [String]
 */
fun ImageView.loadImageFromPath(posterPath: String) {
  Glide.with(context)
    .load(MOVIE_POSTER_BASE_URL + posterPath)
    .into(this)
}