/*package com.prathamngundikere.quviz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.Subject
import com.prathamngundikere.quviz.datamodel.Topic

class SubjectAdapter(
    private val subjectList: List<Subject>,
    private val onTopicClickListener: (Topic) -> Unit
) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hs_subject_rv_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.subjectTextView.text = subject.name

        val topicAdapter = TopicAdapter(subject.topics) { selectedTopic ->
            onTopicClickListener(selectedTopic)
        }
        holder.topicRecyclerView.adapter = topicAdapter
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.hs_subject_tv)
        val topicRecyclerView: RecyclerView = itemView.findViewById(R.id.home_screen_topic_rv)
    }
}*/

package com.prathamngundikere.quviz.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.SubjectScreen
import com.prathamngundikere.quviz.TopicScreen
import com.prathamngundikere.quviz.datamodel.Subject
import com.prathamngundikere.quviz.datamodel.Topic

class SubjectAdapter(private val subjects: List<Subject>,private val onTopicClickListener: (Topic) -> Unit) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.hs_subject_rv_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val position = holder.bindingAdapterPosition
        val subject = subjects[position]
        holder.subjectTextView.text = subject.name
        holder.topicRecyclerView.adapter = TopicAdapter(subject.topics) { selectedTopic ->
            // Handle topic click here
            // For example, open TopicScreen with the selected topic
            val intent = Intent(context, TopicScreen::class.java)
            intent.putExtra("topicName", selectedTopic.name)
            intent.putExtra("imageResourceId", selectedTopic.imageResourceId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.hs_subject_tv)
        val topicRecyclerView: RecyclerView = itemView.findViewById(R.id.home_screen_topic_rv)
        init {
            itemView.setOnClickListener {
                // Handle subject item click here
                // For example, open SubjectScreen with the selected subject
                val intent = Intent(context, SubjectScreen::class.java)
                intent.putExtra("subjectName", subjects[adapterPosition].name)
                context.startActivity(intent)
            }
        }
    }
}

/*
// SubjectAdapter.kt
package com.prathamngundikere.quviz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.Subject
import com.prathamngundikere.quviz.datamodel.Topic

class SubjectAdapter(private val subjects: List<Subject>, private val onTopicClickListener: (Topic) -> Unit) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hs_subject_rv_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjects[position]
        holder.subjectTextView.text = subject.name

        val topicRecyclerView = holder.itemView.findViewById<RecyclerView>(R.id.subjecscreen_rv)
        topicRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        // Initialize the TopicAdapter and set it to the RecyclerView
        val topicAdapter = TopicAdapter(subject.topics) { selectedTopic ->
            onTopicClickListener(selectedTopic)
        }
        topicRecyclerView.adapter = topicAdapter
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.hs_subject_tv)
    }
}
*/
