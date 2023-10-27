package com.prathamngundikere.quviz.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.question
import com.prathamngundikere.quviz.datamodel.selectedans
import com.prathamngundikere.quviz.util.quizscore
import com.prathamngundikere.quviz.util.selectedlist

class QuizQuestionAdapter(private val questionlist: List<question>,
                          private val selectedOptions: SparseArray<Int>)
    : RecyclerView.Adapter<QuizQuestionAdapter.QuizQuestionViewHolder>() {
    private lateinit var context: Context

    // To track selected options for each question

    class QuizQuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questiontv: TextView = itemView.findViewById(R.id.question)
        val optionone: TextView = itemView.findViewById(R.id.optionOne)
        val optiontwo: TextView = itemView.findViewById(R.id.optionTwo)
        val optionthree: TextView = itemView.findViewById(R.id.optionThree)
        val optionfour: TextView = itemView.findViewById(R.id.optionFour)
        val questionid: TextView = itemView.findViewById(R.id.questionumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizQuestionViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_item, parent, false)
        return QuizQuestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionlist.size
    }

    override fun onBindViewHolder(holder: QuizQuestionViewHolder, position: Int) {
        val questionlists = questionlist[position]
        holder.questionid.text = questionlists.id.toString()
        holder.questiontv.text = questionlists.questions
        holder.optionone.text = questionlists.optionOne
        holder.optiontwo.text = questionlists.optionTwo
        holder.optionthree.text = questionlists.optionThree
        holder.optionfour.text = questionlists.optionFour

        val selectedOption = selectedOptions.get(position, -1)
        //Get the selected option or -1 if not selected

        //Set the background of options based on the selected options
        setOptionBackground(holder.optionone,selectedOption,1)
        setOptionBackground(holder.optiontwo,selectedOption,2)
        setOptionBackground(holder.optionthree,selectedOption,3)
        setOptionBackground(holder.optionfour,selectedOption,4)


        holder.optionone.setOnClickListener {
            setSelectedOption(position,1)
            notifyDataSetChanged()//Notify data change to update the view
        }
        holder.optiontwo.setOnClickListener {
            setSelectedOption(position,2)
            notifyDataSetChanged()
        }
        holder.optionthree.setOnClickListener {
            setSelectedOption(position,3)
            notifyDataSetChanged()
        }
        holder.optionfour.setOnClickListener {
            setSelectedOption(position,4)
            notifyDataSetChanged()
        }
        selectedlist[position] = selectedOption
    }

    private fun setSelectedOption(questionPosition: Int,selectedOptionNum: Int){
        selectedOptions.put(questionPosition,selectedOptionNum)
    }

    private fun setOptionBackground(optionView: TextView,selectedOption: Int,optionNum: Int){
        if(selectedOption == optionNum){
            optionView.background = ContextCompat.getDrawable(context,R.drawable.selected_button)
        }else{
            optionView.background = ContextCompat.getDrawable(context,R.drawable.button_background)
        }
    }
}
