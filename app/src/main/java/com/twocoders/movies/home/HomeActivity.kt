package com.twocoders.movies.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.twocoders.movies.R
import com.twocoders.movies.databinding.ActivityHomeLayoutBinding

/**
 * Represents the home screen that is first displayed to the user.
 */
class HomeActivity : AppCompatActivity() {

  private lateinit var views: ActivityHomeLayoutBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    views = DataBindingUtil.setContentView(this, R.layout.activity_home_layout)
  }
}