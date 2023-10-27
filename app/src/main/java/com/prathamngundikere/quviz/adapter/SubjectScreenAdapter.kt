/*package com.prathamngundikere.quviz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.SubjectScreen
import com.prathamngundikere.quviz.datamodel.Topic

class SubjectScreenAdapter(private val topicList: List<Topic>)
    :RecyclerView.Adapter<SubjectScreenAdapter.TopicViewHolder>() {
    private lateinit var context: Context
    class TopicViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val ssimageView : ImageView = itemView.findViewById(R.id.ss_image_iv)
        val sstextView : TextView = itemView.findViewById(R.id.ss_topic_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectScreenAdapter.TopicViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.ss_topic_item,parent,false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectScreenAdapter.TopicViewHolder, position: Int) {
        val subject = topicList[position]
        holder.ssimageView.setImageResource(subject.imageResourceId)
        holder.sstextView.text = subject.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, SubjectScreen::class.java)
            intent.putExtra("subjectName", topicList[position].name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return topicList.size
    }
}*/
/*package com.prathamngundikere.quviz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.SubjectScreen
import com.prathamngundikere.quviz.datamodel.Topic

class SubjectScreenAdapter(private val context: Context, private val topicList: List<Topic>)
    : RecyclerView.Adapter<SubjectScreenAdapter.TopicViewHolder>() {

    class TopicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ssimageView : ImageView = itemView.findViewById(R.id.ss_image_iv)
        val sstextView : TextView = itemView.findViewById(R.id.ss_topic_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectScreenAdapter.TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ss_topic_item, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectScreenAdapter.TopicViewHolder, position: Int) {
        val subject = topicList[position]
        holder.ssimageView.setImageResource(subject.imageResourceId)
        holder.sstextView.text = subject.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, SubjectScreen::class.java)
            intent.putExtra("subjectName", topicList[position].name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }
}
*/
package com.prathamngundikere.quviz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.SubjectScreen
import com.prathamngundikere.quviz.TopicScreen
import com.prathamngundikere.quviz.datamodel.Topic

class SubjectScreenAdapter(private val context: Context, private val topicList: List<Topic>)
    : RecyclerView.Adapter<SubjectScreenAdapter.TopicViewHolder>() {

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ssimageView: ImageView = itemView.findViewById(R.id.ss_image_iv)
        val sstextView: TextView = itemView.findViewById(R.id.ss_topic_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ss_topic_item, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topicList[position]
        holder.ssimageView.setImageResource(topic.imageResourceId)
        holder.sstextView.text = topic.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, TopicScreen::class.java)
            intent.putExtra("topicName", topic.name)
            intent.putExtra("imageResourceId", topic.imageResourceId) // Pass the image ID
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return topicList.size
    }
}

