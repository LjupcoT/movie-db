package com.twocoders.movies.home.moviedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.twocoders.movies.R
import com.twocoders.movies.network.models.ProductionCompany
import com.twocoders.movies.utils.loadImageFromPath

/**
 * [BaseAdapter] for the movie production companies.
 */
class ProductionCompaniesAdapter(
  private val companies: List<ProductionCompany>
) : BaseAdapter() {

  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
    val company = companies[position]
    var imageView = convertView
    if (imageView == null) {
      imageView = LayoutInflater.from(parent?.context)
          .inflate(R.layout.item_production_company, parent, false)
    }

    company.logoPath?.let { (imageView as ImageView).loadImageFromPath(it) }

    return imageView
  }

  override fun getCount() = companies.size

  override fun getItem(position: Int) = companies[position]

  override fun getItemId(position: Int) = 0L
}