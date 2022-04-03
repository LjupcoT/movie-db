package com.twocoders.movies.errorhandling

import android.app.AlertDialog
import android.content.Context
import com.twocoders.movies.R
import com.twocoders.movies.network.models.CustomError


/**
 * Helper object for easier error handling.
 */
object ErrorHandler {

	/**
	 * Handles a [CustomError]. If no custom function is provided for displaying the error on UI,
	 * then it will display a simple [AlertDialog]
	 */
	fun handleError(
    context: Context,
    error: CustomError?,
    showOnUi: ((title: String, message: String) -> Unit)? = null
	) {
		when (error?.code) {
			ErrorCodes.NO_CONNECTION_AVAILABLE.value -> {
				if (showOnUi == null) {
					showInfoDialog(context,
						context.getString(
							R.string.no_connection_title),
						context.getString(R.string.no_connection_description)
					)
				} else {
					showOnUi.invoke(
						context.getString(R.string.no_connection_title),
						context.getString(R.string.no_connection_description)
					)
				}
			}
			else -> {
				showInfoDialog(
					context,
					context.getString(R.string.generic_error_title),
					context.getString(R.string.generic_error_message)
				)
			}
		}
	}

	private fun showInfoDialog(context: Context, title: String, message: String) =
		AlertDialog.Builder(context)
			.setTitle(title)
			.setMessage(message)
			.setNeutralButton(context.getString(R.string.ok_text)) { dialog, _ ->
				dialog.dismiss()
			}
			.create()
			.show()
}