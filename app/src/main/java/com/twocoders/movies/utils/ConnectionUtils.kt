package com.twocoders.movies.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.twocoders.movies.App

/**
 * Utility methods for device's connectivity
 */
object ConnectionUtils {

	/**
	 * Checks if the device is connected to the internet.
	 */
	fun hasConnection(): Boolean {
		val cm = App.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
		cm?.let {
			it.getNetworkCapabilities(it.activeNetwork)?.run {
				return hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
						|| hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
			}
		}
		return false
	}
}