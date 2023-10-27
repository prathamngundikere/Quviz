package com.prathamngundikere.quviz.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.question
import com.prathamngundikere.quviz.util.quizscore
import com.prathamngundikere.quviz.util.selectedlist

class ResultAdapter(private val questionlist: List<question>)
    : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>(){

    private lateinit var context: Context

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questiontv: TextView = itemView.findViewById(R.id.question)
        val useroption: TextView = itemView.findViewById(R.id.user_answer)
        val correctans: TextView = itemView.findViewById(R.id.correctans)
        val explanation: TextView = itemView.findViewById(R.id.explanation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionlist.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val questionlists = questionlist[position]
        holder.questiontv.text = questionlists.questions
        holder.explanation.text = questionlists.explaination
        holder.correctans.text = when(questionlists.correctAnswer){
            1 -> questionlists.optionOne
            2 -> questionlists.optionTwo
            3 -> questionlists.optionThree
            4 -> questionlists.optionFour
            else -> questionlists.optionOne
        }
        holder.useroption.text = when(selectedlist[position]){
            1 -> questionlists.optionOne
            2 -> questionlists.optionTwo
            3 -> questionlists.optionThree
            4 -> questionlists.optionFour
            else -> "Not Choosen"
        }
        if (holder.useroption.text == holder.correctans.text){
            holder.useroption.background = ContextCompat.getDrawable(context,R.drawable.corrrect_selected_button)
        }else if (holder.useroption.text == "Not Choosen"){
            holder.useroption.background = ContextCompat.getDrawable(context,R.drawable.button_background)
        }else{
            holder.useroption.background = ContextCompat.getDrawable(context,R.drawable.wrong_selected_button)
        }
    }
}