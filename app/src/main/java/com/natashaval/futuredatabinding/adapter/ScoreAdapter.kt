package com.natashaval.futuredatabinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natashaval.futuredatabinding.R
import com.natashaval.futuredatabinding.databinding.ItemScoreBinding

/**
 * Created by natasha.santoso on 20/01/21.
 */
class ScoreAdapter(private val scoreList: List<Int>, private val listener: ScoreListener)
    : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false)
        return ScoreViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.bind(scoreList[position])
    }

    override fun getItemCount(): Int = scoreList.size

    inner class ScoreViewHolder(view: View, private val listener: ScoreListener): RecyclerView.ViewHolder(view) {
        private val binding: ItemScoreBinding? = DataBindingUtil.bind(view)

        fun bind(value: Int) {
            binding?.score = value
            binding?.root?.setOnClickListener { listener.onScoreClicked(value) }
        }
    }

    interface ScoreListener {
        fun onScoreClicked(value: Int)
    }
}