package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.databinding.ActivityMainBinding
import com.natashaval.futuredatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

  private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.lifecycleOwner = this
    binding.viewmodel = viewModel
    binding.activity = this

    binding.btScorePlus.setOnClickListener {
      viewModel.updateScore(1)
    }
    binding.btScoreMinus.setOnClickListener {
      viewModel.updateScore(-1)
    }
    binding.btProfileFragment.setOnClickListener {
      openFragment()
    }
  }

  fun openActivity(view: View) {
    val intent = Intent(this, ProfileActivity::class.java)
    intent.putExtra(FIRST_NAME_KEY, viewModel.user.firstName)
    intent.putExtra(LAST_NAME_KEY, viewModel.user.lastName)
    startActivity(intent)
  }

  private fun openFragment() {
    val fragment = ProfileFragment.newInstance(viewModel.user.firstName, viewModel.user.lastName)
    fragment.show(supportFragmentManager, ProfileFragment.TAG)
  }
}