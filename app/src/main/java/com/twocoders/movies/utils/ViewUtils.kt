package com.twocoders.movies.utils

import android.view.View

/**
 * Sets [View] visibility to [View.VISIBLE] or [View.GONE] according the passed parameter
 *
 * @param shouldShow [Boolean]
 */
fun View.show(shouldShow: Boolean) {
  visibility = if (shouldShow) View.VISIBLE else View.GONE
}