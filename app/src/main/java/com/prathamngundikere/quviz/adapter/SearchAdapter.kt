package com.prathamngundikere.quviz.adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.TopicScreen
import com.prathamngundikere.quviz.datamodel.Topic
import android.content.Context
class SearchAdapter(var mList : List<Topic>)
    : RecyclerView.Adapter<SearchAdapter.searchviewholder>() {
    private lateinit var context: Context
    inner class searchviewholder(itemView : View):RecyclerView.ViewHolder(itemView){
        val logoim : ImageView = itemView.findViewById(R.id.ss_image_iv)
        val titletv : TextView = itemView.findViewById(R.id.ss_topic_tv)
    }
    fun setFilteredList(mList: List<Topic>){
        this.mList = mList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): searchviewholder {
        context = p0.context
        var view = LayoutInflater.from(p0.context).inflate(R.layout.ss_topic_item,p0,false)
        return  searchviewholder(view)
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(p0: searchviewholder, p1: Int) {
        val position2 = p0.bindingAdapterPosition
        val topic = mList[p1]
        p0.logoim.setImageResource(mList[p1].imageResourceId)
        p0.titletv.text = mList[p1].name
        p0.itemView.setOnClickListener {
            val intent = Intent(context, TopicScreen::class.java)
            intent.putExtra("topicName", topic.name)
            intent.putExtra("imageResourceId", topic.imageResourceId) // Pass the image ID
            context.startActivity(intent)
        }
    }
}