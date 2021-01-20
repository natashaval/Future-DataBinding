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
class ScoreAdapter(private val scoreList: List<Int>): RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.bind(scoreList[position])
    }

    override fun getItemCount(): Int = scoreList.size

    inner class ScoreViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private val binding: ItemScoreBinding? = DataBindingUtil.bind(view)

        init {
            view.setOnClickListener(this)
        }

        fun bind(value: Int) {
            binding?.score = value
        }

        override fun onClick(v: View?) {
            binding?.tvScoreData?.run {
                text = "Clicked! ${this.text}"
            }
        }
    }
}