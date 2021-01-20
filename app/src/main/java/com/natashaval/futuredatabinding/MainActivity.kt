package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.databinding.ActivityMainBinding
import com.natashaval.futuredatabinding.model.User
import com.natashaval.futuredatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

  private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.viewmodel = viewModel

    val plusScore = findViewById<Button>(R.id.bt_score_plus)
    plusScore.setOnClickListener {
      viewModel.updateScore(1)
    }
    val minusScore = findViewById<Button>(R.id.bt_score_minus)
    minusScore.setOnClickListener {
      viewModel.updateScore(-1)
    }
  }

  fun openActivity(view: View) {
    val intent = Intent(this, ProfileActivity::class.java)
    intent.putExtra(FIRST_NAME_KEY, viewModel.user.firstName)
    intent.putExtra(LAST_NAME_KEY, viewModel.user.lastName)
    startActivity(intent)
  }

  fun openFragment(view: View) {
    val fragment = ProfileFragment.newInstance(viewModel.user.firstName, viewModel.user.lastName)
    fragment.show(supportFragmentManager, ProfileFragment.TAG)
  }
}