package com.natashaval.futuredatabinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natashaval.futuredatabinding.R

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

    class ScoreViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private val v: View = view
        private val textView: TextView

        init {
            v.setOnClickListener(this)
            textView = v.findViewById(R.id.tv_score_data)
        }

        fun bind(value: Int) {
            textView.text = "Score: $value"
        }

        override fun onClick(v: View?) {
            textView.text = "Clicked! ${textView.text}"
        }
    }
}