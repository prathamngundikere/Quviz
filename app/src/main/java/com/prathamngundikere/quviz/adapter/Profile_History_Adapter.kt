package com.prathamngundikere.quviz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.userfirebase

class Profile_History_Adapter(private val historylist: ArrayList<userfirebase>)
    : RecyclerView.Adapter<Profile_History_Adapter.ViewHolder>() {
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val quizname : TextView = itemview.findViewById(R.id.pl_quizname)
        val pldate : TextView = itemview.findViewById(R.id.pl_date)
        val plscore : TextView = itemview.findViewById(R.id.pl_score)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Profile_History_Adapter.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_list_item,parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: Profile_History_Adapter.ViewHolder, position: Int) {
        val current = historylist[position]
        holder.quizname.text = current.quizname
        holder.pldate.text = current.presenttime
        holder.plscore.text = "Score = ${current.userscore}"
    }

    override fun getItemCount(): Int {
        return historylist.size
    }
}