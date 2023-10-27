package com.prathamngundikere.quviz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.Quiz_Screen
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.quiz

class QuizAdapter(private val context: Context, private val quizlist : List<quiz>) : RecyclerView.Adapter<QuizAdapter.QuvizViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizAdapter.QuvizViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ts_quiz_item, parent, false)
        return QuvizViewHolder(view)
    }

    class QuvizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ts_quiz_tv: TextView = itemView.findViewById(R.id.ts_quiz_tv)
    }

    override fun getItemCount(): Int {
        return quizlist.size
    }

    override fun onBindViewHolder(holder: QuizAdapter.QuvizViewHolder, position: Int) {
        val topic = quizlist[position]
        holder.ts_quiz_tv.text = topic.id
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Quiz_Screen::class.java)
            intent.putExtra("quizname",topic.id)
            context.startActivity(intent)
        }
    }
}