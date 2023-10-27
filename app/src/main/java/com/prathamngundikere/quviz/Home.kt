package com.prathamngundikere.quviz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.adapter.SubjectAdapter
import com.prathamngundikere.quviz.datamodel.Subject
import com.prathamngundikere.quviz.datamodel.Topic
import com.prathamngundikere.quviz.util.getSubjectsList
class Home : Fragment(R.layout.fragment_home) {
    private lateinit var adapter: SubjectAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var subjectlist: List<Subject>
    private lateinit var intent: Intent
    private lateinit var selectedTopic : Topic
    private lateinit var hscore : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val  totalscoreq = sharedPreferences.getInt("UserTotalScores", 0)
        hscore = view.findViewById(R.id.hs_score)
        hscore.text = "${totalscoreq}⭐"
        subjectlist = getShuffledSubjects()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.homerv)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SubjectAdapter(subjectlist){ selectedTopic ->
            val intent = Intent(context, TopicScreen::class.java)
            intent.putExtra("topicName", selectedTopic.name)
            intent.putExtra("imageResourceId2", selectedTopic.imageResourceId) // Pass the image ID
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
    private fun getShuffledSubjects():List<Subject>{
        val originalSubjects = getSubjectsList()
        return originalSubjects.shuffled()
    }
}