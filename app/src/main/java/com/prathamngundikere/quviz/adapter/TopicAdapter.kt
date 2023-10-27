package com.prathamngundikere.quviz.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.Topic

class TopicAdapter(
    private val topicList: List<Topic>,
    private val onTopicClickListener: (Topic) -> Unit) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hs_topic_item, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topicList[position]
        holder.topicTextView.text = topic.name
        holder.topicImageView.setImageResource(topic.imageResourceId)

        holder.itemView.setOnClickListener {
            onTopicClickListener(topic)
        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicTextView: TextView = itemView.findViewById(R.id.topicTextView)
        val topicImageView: ImageView = itemView.findViewById(R.id.topicImageView)
    }
}
/*
// TopicAdapter.kt
package com.prathamngundikere.quviz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.Topic

class TopicAdapter(private val topics: List<Topic>, private val onTopicClickListener: (Topic) -> Unit) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ss_topic_item, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.topicTextView.text = topic.name
        holder.topicImageView.setImageResource(topic.imageResourceId)
        holder.itemView.setOnClickListener {
            onTopicClickListener(topic)
        }
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    inner class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicTextView: TextView = itemView.findViewById(R.id.ss_topic_tv)
        val topicImageView: ImageView = itemView.findViewById(R.id.ss_image_iv)
    }
}
*/
