package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.adapter.ScoreAdapter
import com.natashaval.futuredatabinding.databinding.ActivityMainBinding
import com.natashaval.futuredatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

  private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
  private lateinit var binding: ActivityMainBinding
  private var mScoreList: MutableList<Int> = mutableListOf()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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
    generateScoreList()
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

  private fun generateScoreList() {
    binding.btGenerateScore.setOnClickListener {
      val lastScore = viewModel.newScore.value ?: 0
      mScoreList.clear()
      for (i in 0..lastScore) {
        mScoreList.add(i)
      }
      showScoreBoard()
    }
  }

  private fun showScoreBoard() {
    val scoreAdapter = ScoreAdapter(mScoreList)
    with(binding.rvScoreBoard) {
      adapter = scoreAdapter
      layoutManager = LinearLayoutManager(this@MainActivity)
//      layoutManager = GridLayoutManager(this@MainActivity, 2)
    }
  }
}