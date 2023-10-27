/*package com.prathamngundikere.quviz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.adapter.SubjectAdapter
import com.prathamngundikere.quviz.adapter.SubjectScreenAdapter
import com.prathamngundikere.quviz.adapter.TopicAdapter
import com.prathamngundikere.quviz.datamodel.Topic
import com.prathamngundikere.quviz.util.BiologyTopics
import com.prathamngundikere.quviz.util.ChemistryTopics
import com.prathamngundikere.quviz.util.CivicsTopics
import com.prathamngundikere.quviz.util.CivilTopics
import com.prathamngundikere.quviz.util.CommerceTopics
import com.prathamngundikere.quviz.util.ComputerScienceTopics
import com.prathamngundikere.quviz.util.CurrentAffairsTopics
import com.prathamngundikere.quviz.util.ElectronicsTopics
import com.prathamngundikere.quviz.util.FashionTopics
import com.prathamngundikere.quviz.util.GeographyTopics
import com.prathamngundikere.quviz.util.HistoryTopics
import com.prathamngundikere.quviz.util.MathematicsTopics
import com.prathamngundikere.quviz.util.MechanicalTopics
import com.prathamngundikere.quviz.util.MoviesTopics
import com.prathamngundikere.quviz.util.PhysicsTopics
import com.prathamngundikere.quviz.util.SportsTopics
import com.prathamngundikere.quviz.util.StatisticsTopics

class SubjectScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var subjectAdapter : SubjectScreenAdapter
    private lateinit var list:Topic
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_screen)

        val subjectName = intent.getStringExtra("subjectName")
        findViewById<TextView>(R.id.subject_name_tv).text = subjectName
        recyclerView = findViewById(R.id.subjecscreen_rv)
        when{
            subjectName=="Physics" -> subjectAdapter = SubjectScreenAdapter(PhysicsTopics())
            subjectName=="Biology" -> subjectAdapter = SubjectScreenAdapter(BiologyTopics())
            subjectName=="Chemistry" -> subjectAdapter = SubjectScreenAdapter(ChemistryTopics())
            subjectName=="Mathematics" -> subjectAdapter = SubjectScreenAdapter(MathematicsTopics())
            subjectName=="Computer Science" -> subjectAdapter = SubjectScreenAdapter(ComputerScienceTopics())
            subjectName=="History" -> subjectAdapter = SubjectScreenAdapter(HistoryTopics())
            subjectName=="Civics" -> subjectAdapter = SubjectScreenAdapter(CivicsTopics())
            subjectName=="Geography" -> subjectAdapter = SubjectScreenAdapter(GeographyTopics())
            subjectName=="Commerce" -> subjectAdapter = SubjectScreenAdapter(CommerceTopics())
            subjectName=="Statistics" -> subjectAdapter = SubjectScreenAdapter(StatisticsTopics())
            subjectName=="Mechanical" -> subjectAdapter = SubjectScreenAdapter(MechanicalTopics())
            subjectName=="Civil" -> subjectAdapter = SubjectScreenAdapter(CivilTopics())
            subjectName=="Electronics" -> subjectAdapter = SubjectScreenAdapter(ElectronicsTopics())
            subjectName=="Movies" -> subjectAdapter = SubjectScreenAdapter(MoviesTopics())
            subjectName=="Sports" -> subjectAdapter = SubjectScreenAdapter(SportsTopics())
            subjectName=="Current Affairs" -> subjectAdapter = SubjectScreenAdapter(CurrentAffairsTopics())
            subjectName=="Fashion" -> subjectAdapter = SubjectScreenAdapter(FashionTopics())
        }
        recyclerView.adapter = subjectAdapter
        // Handle subject data and UI here...
    }
}
/*
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.R
import com.prathamngundikere.quviz.datamodel.Subject
import com.prathamngundikere.quviz.util.getSubjectsList

class SubjectScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_screen)
        val subjectName = intent.getStringExtra("subjectName")
        findViewById<TextView>(R.id.subject_name_tv).text = subjectName
        val subjectRecyclerView: RecyclerView = findViewById(R.id.subjecscreen_rv)
        subjectRecyclerView.layoutManager = LinearLayoutManager(this)
        val subjects: List<Subject> = getSubjectsList()
        val subjectAdapter = SubjectAdapter2(this, subjects)
        subjectRecyclerView.adapter = subjectAdapter
    }
}*/
/*
// SubjectScreen.kt
package com.prathamngundikere.quviz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.adapter.SubjectAdapter
import com.prathamngundikere.quviz.adapter.TopicAdapter
import com.prathamngundikere.quviz.datamodel.Subject
import com.prathamngundikere.quviz.util.getSubjectsList

class SubjectScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_screen)

        val subjectName = intent.getStringExtra("subjectName")
        findViewById<TextView>(R.id.subject_name_tv).text = subjectName

        val subjectsList: List<Subject> = getSubjectsList()

        val subjectRecyclerView = findViewById<RecyclerView>(R.id.subjecscreen_rv)
        subjectRecyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the SubjectAdapter and set it to the RecyclerView
        val subjectAdapter = SubjectAdapter(subjectsList) { selectedTopic ->
            val intent = Intent(this, TopicScreen::class.java)
            intent.putExtra("topicName", selectedTopic.name)
            startActivity(intent)
        }
        subjectRecyclerView.adapter = subjectAdapter
    }
}
*/*/
package com.prathamngundikere.quviz

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.adapter.SubjectAdapter
import com.prathamngundikere.quviz.adapter.SubjectScreenAdapter
import com.prathamngundikere.quviz.datamodel.Topic
import com.prathamngundikere.quviz.util.BiologyTopics
import com.prathamngundikere.quviz.util.ChemistryTopics
import com.prathamngundikere.quviz.util.CivicsTopics
import com.prathamngundikere.quviz.util.CivilTopics
import com.prathamngundikere.quviz.util.CommerceTopics
import com.prathamngundikere.quviz.util.ComputerScienceTopics
import com.prathamngundikere.quviz.util.CurrentAffairsTopics
import com.prathamngundikere.quviz.util.ElectronicsTopics
import com.prathamngundikere.quviz.util.FashionTopics
import com.prathamngundikere.quviz.util.GeographyTopics
import com.prathamngundikere.quviz.util.HistoryTopics
import com.prathamngundikere.quviz.util.MathematicsTopics
import com.prathamngundikere.quviz.util.MechanicalTopics
import com.prathamngundikere.quviz.util.MoviesTopics
import com.prathamngundikere.quviz.util.PhysicsTopics
import com.prathamngundikere.quviz.util.SportsTopics
import com.prathamngundikere.quviz.util.StatisticsTopics

class SubjectScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var subjectAdapter : SubjectScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_screen)
        val backBtn : ImageView = findViewById(R.id.BakBTN)
        backBtn.setOnClickListener {
           super.onBackPressed()
        }
        val subjectName = intent.getStringExtra("subjectName")
        findViewById<TextView>(R.id.subject_name_tv).text = subjectName
        recyclerView = findViewById(R.id.subjecscreen_rv)
        val topicList: List<Topic> = when (subjectName) {
            "Physics" -> PhysicsTopics()
            "Biology" -> BiologyTopics()
            "Chemistry" -> ChemistryTopics()
            "Mathematics" -> MathematicsTopics()
            "Computer Science" -> ComputerScienceTopics()
            "History" -> HistoryTopics()
            "Civics" -> CivicsTopics()
            "Geography" -> GeographyTopics()
            "Commerce" -> CommerceTopics()
            "Statistics" -> StatisticsTopics()
            "Mechanical" -> MechanicalTopics()
            "Civil" -> CivilTopics()
            "Electronics" -> ElectronicsTopics()
            "Movies" -> MoviesTopics()
            "Sports" -> SportsTopics()
            "Current Affairs" -> CurrentAffairsTopics()
            "Fashion" -> FashionTopics()
            else -> emptyList() // Return an empty list if subjectName doesn't match any
        }

        // Initialize the SubjectScreenAdapter and set it to the RecyclerView
        subjectAdapter = SubjectScreenAdapter(this,topicList)
        recyclerView.adapter = subjectAdapter
    }
}

