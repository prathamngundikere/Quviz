package com.prathamngundikere.quviz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.prathamngundikere.quviz.adapter.QuizAdapter
import com.prathamngundikere.quviz.adapter.SubjectScreenAdapter
import com.prathamngundikere.quviz.datamodel.Topic
import com.prathamngundikere.quviz.datamodel.quiz
import com.prathamngundikere.quviz.util.FashionTopics
import com.prathamngundikere.quviz.util.accountingquiz
import com.prathamngundikere.quviz.util.acidsandbasesquiz
import com.prathamngundikere.quviz.util.algebraquiz
import com.prathamngundikere.quviz.util.algorithmquiz
import com.prathamngundikere.quviz.util.analogelectronicsquiz
import com.prathamngundikere.quviz.util.ancientcivilizationsquiz
import com.prathamngundikere.quviz.util.arithmaticsquiz
import com.prathamngundikere.quviz.util.artificialintelligencequiz
import com.prathamngundikere.quviz.util.astrophysicsquiz
import com.prathamngundikere.quviz.util.athleticsquiz
import com.prathamngundikere.quviz.util.atomicstructurequiz
import com.prathamngundikere.quviz.util.atomicstructurequiz1
import com.prathamngundikere.quviz.util.automativeengineeringquiz
import com.prathamngundikere.quviz.util.baseballquiz
import com.prathamngundikere.quviz.util.basketballquiz
import com.prathamngundikere.quviz.util.beautyandmakeupquiz
import com.prathamngundikere.quviz.util.biochemistryquiz
import com.prathamngundikere.quviz.util.biotechnologyquiz
import com.prathamngundikere.quviz.util.buildingmaterialsquiz
import com.prathamngundikere.quviz.util.businesslawquiz
import com.prathamngundikere.quviz.util.businessstudiesquiz
import com.prathamngundikere.quviz.util.calculusquiz
import com.prathamngundikere.quviz.util.cellbiologyquiz
import com.prathamngundikere.quviz.util.chemicalBondingquiz
import com.prathamngundikere.quviz.util.chemicalequilibriumquiz
import com.prathamngundikere.quviz.util.citizenshipanddemocracyquiz
import com.prathamngundikere.quviz.util.civicresponsibilitiesquiz
import com.prathamngundikere.quviz.util.civilrightsmovementquiz
import com.prathamngundikere.quviz.util.climateandweatherquiz
import com.prathamngundikere.quviz.util.clothingstylesquiz
import com.prathamngundikere.quviz.util.coldwarsquiz
import com.prathamngundikere.quviz.util.colonialismquiz
import com.prathamngundikere.quviz.util.communicationsystemsquiz
import com.prathamngundikere.quviz.util.computernetworksquiz
import com.prathamngundikere.quviz.util.constitutionandrightsquiz
import com.prathamngundikere.quviz.util.constructionmanagementquiz
import com.prathamngundikere.quviz.util.controlsystemsquiz
import com.prathamngundikere.quviz.util.cricketquiz
import com.prathamngundikere.quviz.util.culturalgeographyquiz
import com.prathamngundikere.quviz.util.cybersecurity
import com.prathamngundikere.quviz.util.databasequiz
import com.prathamngundikere.quviz.util.datastructurequiz
import com.prathamngundikere.quviz.util.datavisualizationquiz
import com.prathamngundikere.quviz.util.decolonizationquiz
import com.prathamngundikere.quviz.util.descriptivestatisticsquiz
import com.prathamngundikere.quviz.util.differentialequationsquiz
import com.prathamngundikere.quviz.util.digitalelectronicsquiz
import com.prathamngundikere.quviz.util.ecologyquiz
import com.prathamngundikere.quviz.util.economicsquiz
import com.prathamngundikere.quviz.util.electionsandvotingquiz
import com.prathamngundikere.quviz.util.electromagnetismquiz
import com.prathamngundikere.quviz.util.electronicircuitsquiz
import com.prathamngundikere.quviz.util.embeddedsystemsquiz
import com.prathamngundikere.quviz.util.empty
import com.prathamngundikere.quviz.util.engineeringdesignquiz
import com.prathamngundikere.quviz.util.enterpeneurshipquiz
import com.prathamngundikere.quviz.util.environmentalengineeringquiz
import com.prathamngundikere.quviz.util.environmentalgeographyquiz
import com.prathamngundikere.quviz.util.evolutionquiz
import com.prathamngundikere.quviz.util.experimentaldesignquiz
import com.prathamngundikere.quviz.util.fashionaccessoriesquiz
import com.prathamngundikere.quviz.util.fashionbrandsquiz
import com.prathamngundikere.quviz.util.fashiondesignersquiz
import com.prathamngundikere.quviz.util.fashionmagazinesquiz
import com.prathamngundikere.quviz.util.fashionphotographyquiz
import com.prathamngundikere.quviz.util.fashionshowsquiz
import com.prathamngundikere.quviz.util.fashiontrendsquiz
import com.prathamngundikere.quviz.util.financequiz
import com.prathamngundikere.quviz.util.financialmanagementquiz
import com.prathamngundikere.quviz.util.fluidmechanicsquiz
import com.prathamngundikere.quviz.util.footballquiz
import com.prathamngundikere.quviz.util.geneticsquiz
import com.prathamngundikere.quviz.util.geometryquiz
import com.prathamngundikere.quviz.util.geotechnicalengineeringquiz
import com.prathamngundikere.quviz.util.gisquiz
import com.prathamngundikere.quviz.util.globalizationquiz
import com.prathamngundikere.quviz.util.golfquiz
import com.prathamngundikere.quviz.util.hairstylesquiz
import com.prathamngundikere.quviz.util.heatransferquiz
import com.prathamngundikere.quviz.util.hockeyquiz
import com.prathamngundikere.quviz.util.humananatomyquiz
import com.prathamngundikere.quviz.util.humangeographyquiz
import com.prathamngundikere.quviz.util.humanrightsquiz
import com.prathamngundikere.quviz.util.hypothesistestingquiz
import com.prathamngundikere.quviz.util.immunologyquiz
import com.prathamngundikere.quviz.util.industrialrevolutionquiz
import com.prathamngundikere.quviz.util.infrastructuredevelopmentquiz
import com.prathamngundikere.quviz.util.internationalrelationsquiz
import com.prathamngundikere.quviz.util.internationaltradequiz
import com.prathamngundikere.quviz.util.landformsandbiomesquiz
import com.prathamngundikere.quviz.util.lawandjusticequiz
import com.prathamngundikere.quviz.util.linearalgebraquiz
import com.prathamngundikere.quviz.util.manufacturingprocessesquiz
import com.prathamngundikere.quviz.util.marketingquiz
import com.prathamngundikere.quviz.util.materialssciencquiz
import com.prathamngundikere.quviz.util.mathematicallogicquiz
import com.prathamngundikere.quviz.util.mechanicsofmachinesquiz
import com.prathamngundikere.quviz.util.mechanicsquiz
import com.prathamngundikere.quviz.util.microbiologyquiz
import com.prathamngundikere.quviz.util.microelectronicsquiz
import com.prathamngundikere.quviz.util.naturalresourcesquiz
import com.prathamngundikere.quviz.util.nuclearphysicsquiz
import com.prathamngundikere.quviz.util.numbertheoryquiz
import com.prathamngundikere.quviz.util.oopquiz
import com.prathamngundikere.quviz.util.operatingsystemquiz
import com.prathamngundikere.quviz.util.opticsquiz
import com.prathamngundikere.quviz.util.organichemistryquiz
import com.prathamngundikere.quviz.util.particalphysicsquiz
import com.prathamngundikere.quviz.util.perodictablequiz
import com.prathamngundikere.quviz.util.physicalgeoraphyquiz
import com.prathamngundikere.quviz.util.physiologyquiz
import com.prathamngundikere.quviz.util.plantbiologyquiz
import com.prathamngundikere.quviz.util.politicalsystemsquiz
import com.prathamngundikere.quviz.util.populationandmigrationquiz
import com.prathamngundikere.quviz.util.powerelectronicsquiz
import com.prathamngundikere.quviz.util.probabilitydistributionsquiz
import com.prathamngundikere.quviz.util.probabilityquiz
import com.prathamngundikere.quviz.util.programmingconceptsquiz
import com.prathamngundikere.quviz.util.publicpolicyquiz
import com.prathamngundikere.quviz.util.quantumechanicsquiz
import com.prathamngundikere.quviz.util.quizscore
import com.prathamngundikere.quviz.util.redoxrectionsquiz
import com.prathamngundikere.quviz.util.regressionanalysisquiz
import com.prathamngundikere.quviz.util.relativityquiz
import com.prathamngundikere.quviz.util.renaissancequiz
import com.prathamngundikere.quviz.util.revolutionarymovementsquiz
import com.prathamngundikere.quviz.util.roboticsandautomationquiz
import com.prathamngundikere.quviz.util.samplingtechniqesquiz
import com.prathamngundikere.quviz.util.selectedlist
import com.prathamngundikere.quviz.util.signalprocessingquiz
import com.prathamngundikere.quviz.util.statesofmatterquiz
import com.prathamngundikere.quviz.util.staticsandynamicsquiz
import com.prathamngundikere.quviz.util.statisticalmodelingquiz
import com.prathamngundikere.quviz.util.statisticalsoftwarequiz
import com.prathamngundikere.quviz.util.stochiometryquiz
import com.prathamngundikere.quviz.util.structuralengineeringquiz
import com.prathamngundikere.quviz.util.supplychainmanagementquiz
import com.prathamngundikere.quviz.util.surveyandmappingquiz
import com.prathamngundikere.quviz.util.swimmingquiz
import com.prathamngundikere.quviz.util.tennisquiz
import com.prathamngundikere.quviz.util.thermodynamicschemistryquiz
import com.prathamngundikere.quviz.util.thermodynamicsphysicsquiz
import com.prathamngundikere.quviz.util.thermodynamicsquiz
import com.prathamngundikere.quviz.util.timeseriesanalysisquiz
import com.prathamngundikere.quviz.util.transporatationengineeringquiz
import com.prathamngundikere.quviz.util.trigonometryquiz
import com.prathamngundikere.quviz.util.typesofgovernmentquiz
import com.prathamngundikere.quviz.util.urbanplanningquiz
import com.prathamngundikere.quviz.util.vlsidesignquiz
import com.prathamngundikere.quviz.util.vollyballquiz
import com.prathamngundikere.quviz.util.waterresourceengineeringquiz
import com.prathamngundikere.quviz.util.wavesandoscillationsquiz
import com.prathamngundikere.quviz.util.webdevelopment
import com.prathamngundikere.quviz.util.worldgeographyquiz
import com.prathamngundikere.quviz.util.worldwarsquiz

class TopicScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var quizAdapter: QuizAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_screen)
        val toolbar:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val collapsingToolbarLayout:CollapsingToolbarLayout = findViewById(R.id.collap_tb_layout)
        // Inside the TopicScreen activity
        selectedlist = intArrayOf(0,0,0,0,0,0,0,0,0,0)
        quizscore = 0
        val backBtn : TextView = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            super.onBackPressed()
        }
// When launching from HomeScreen
        val subjectName = intent.getStringExtra("topicName")
        val imageResourceId1 = intent.getIntExtra("imageResourceId", 0)
// Now, you can display this data in the TopicScreen activity as needed.

// When launching from SubjectScreen
        val topicName = intent.getStringExtra("topicName")
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)
// Display this data in the TopicScreen activity as needed.
        findViewById<TextView>(R.id.ts_topic_name_tv).text = subjectName
        findViewById<ImageView>(R.id.ts_imageView_iv).setImageResource(imageResourceId1)
      //  val topicName = intent.getStringExtra("topicName")

       //val imageResourceId = intent.getIntExtra("imageResourceId",0)
        findViewById<TextView>(R.id.ts_topic_name_tv).text = topicName

        // Inside the TopicScreen activity
       // val imageResourceId = intent.getIntExtra("imageResourceId", 0)
        findViewById<ImageView>(R.id.ts_imageView_iv).setImageResource(imageResourceId)
        collapsingToolbarLayout.title = findViewById<TextView>(R.id.ts_topic_name_tv).text
        //val imageView = findViewById<ImageView>(R.id.ts_imageView_iv)
        //imageView.setImageResource(imageResourceId)
        // Handle topic data and UI here...
        recyclerView = findViewById(R.id.ts_quiz_rv)
        val quizlist : List<quiz> = when (topicName) {
            "Plant Biology" -> plantbiologyquiz()
            "Object-Oriented Programming" -> oopquiz()
            "Data Structures" -> datastructurequiz()
            "Cybersecurity" -> cybersecurity()
            "Web Development" -> webdevelopment()
            "Computer Networks" -> computernetworksquiz()
            "Artificial Intelligence" -> artificialintelligencequiz()
            "Programming Concepts" -> programmingconceptsquiz()
            "Databases" -> databasequiz()
            "Operating Systems" -> operatingsystemquiz()
            "Algorithms" -> algorithmquiz()
            "Atomic Structure" -> atomicstructurequiz()
            "Periodic Table" -> perodictablequiz()
            "Chemical Bonding" -> chemicalBondingquiz()
            "Stoichiometry" -> stochiometryquiz()
            "States of matter" -> statesofmatterquiz()
            "Acids and Bases" -> acidsandbasesquiz()
            "Redox Rections" -> redoxrectionsquiz()
            "Organic Chemistry" -> organichemistryquiz()
            "Thermodynamics Chemistry" -> thermodynamicschemistryquiz()
            "Chemical Equilibrium" -> chemicalequilibriumquiz()
            "Geotechnical Engineering" -> geotechnicalengineeringquiz()
            "Surveying and Mapping" -> surveyandmappingquiz()
            "Environmental Engineering" -> environmentalengineeringquiz()
            "Structural Engineering" -> structuralengineeringquiz()
            "Building Materials and Technology" -> buildingmaterialsquiz()
            "Urban Planning" -> urbanplanningquiz()
            "Water Resources Engineering" -> waterresourceengineeringquiz()
            "Infrastructure Development" -> infrastructuredevelopmentquiz()
            "Construction Management" -> constructionmanagementquiz()
            "Transportation Engineering" -> transporatationengineeringquiz()
            "Mechanics" -> mechanicsquiz()
            "Thermodynamics Physics" -> thermodynamicsphysicsquiz()
            "Electromagnetism" -> electromagnetismquiz()
            "Optics" -> opticsquiz()
            "Waves and Oscillations" -> wavesandoscillationsquiz()
            "Quantum Mechanics" -> quantumechanicsquiz()
            "Relativity" -> relativityquiz()
            "Nuclear Physics" -> nuclearphysicsquiz()
            "Particle Physics" -> particalphysicsquiz()
            "Astrophysics" -> astrophysicsquiz()
            "Cell Biology" -> cellbiologyquiz()
            "Genetics" -> geneticsquiz()
            "Ecology" -> ecologyquiz()
            "Human Anatomy" -> humananatomyquiz()
            "Physiology" -> physiologyquiz()
            "Microbiology" -> microbiologyquiz()
            "Biochemistry" -> biochemistryquiz()
            "Immunology" -> immunologyquiz()
            "Biotechnology" -> biotechnologyquiz()
            "Evolution" -> evolutionquiz()
            "Arithmatic" -> arithmaticsquiz()
            "Algebra" -> algebraquiz()
            "Geometry" -> geometryquiz()
            "Trigonometry" -> trigonometryquiz()
            "Calculus" -> calculusquiz()
            "Probability" -> probabilityquiz()
            "Number Theory" -> numbertheoryquiz()
            "Linear Algebra" -> linearalgebraquiz()
            "Differential Equaions" -> differentialequationsquiz()
            "Mathematical Logic" -> mathematicallogicquiz()
            "Ancient Civilizations" -> ancientcivilizationsquiz()
            "World Wars" -> worldwarsquiz()
            "Renaissance" -> renaissancequiz()
            "Colonialism and Imperialism" -> colonialismquiz()
            "Industrial Revolution" -> industrialrevolutionquiz()
            "Cold War" -> coldwarsquiz()
            "Civil Rights Movement" -> civilrightsmovementquiz()
            "Globalization" -> globalizationquiz()
            "Revolutionary Movements" -> revolutionarymovementsquiz()
            "Decolonization" -> decolonizationquiz()
            "Types of Government" -> typesofgovernmentquiz()
            "Constitution and Rights" -> constitutionandrightsquiz()
            "Citizenship and Democracy" -> citizenshipanddemocracyquiz()
            "Political Systems" -> politicalsystemsquiz()
            "Law and Justice" -> lawandjusticequiz()
            "Elections and Voting" -> electionsandvotingquiz()
            "Public Policy" -> publicpolicyquiz()
            "International Relations" -> internationalrelationsquiz()
            "Human Rights" -> humanrightsquiz()
            "Civic Responsibilities" -> civicresponsibilitiesquiz()
            "Physical Geography" -> physicalgeoraphyquiz()
            "Human Geography" -> humangeographyquiz()
            "World Geography" -> worldgeographyquiz()
            "Cultural Geography" -> culturalgeographyquiz()
            "Environmental Geography" -> environmentalgeographyquiz()
            "Geographic Information Systems (GIS)" -> gisquiz()
            "Population and Migration" -> populationandmigrationquiz()
            "Landforms and Biomes" -> landformsandbiomesquiz()
            "Climate and Weather" -> climateandweatherquiz()
            "Natural Resources" -> naturalresourcesquiz()
            "Business Studies" -> businessstudiesquiz()
            "Accounting" -> accountingquiz()
            "Economics" -> economicsquiz()
            "Marketing" -> marketingquiz()
            "Finance" -> financequiz()
            "Entrepreneurship" -> enterpeneurshipquiz()
            "Supply Chain Management" -> supplychainmanagementquiz()
            "International Trade" -> internationaltradequiz()
            "Business Law" -> businesslawquiz()
            "Financial Management" -> financialmanagementquiz()
            "Descriptive Statistics" -> descriptivestatisticsquiz()
            "Probability Distributions" -> probabilitydistributionsquiz()
            "Hypothesis Testing" -> hypothesistestingquiz()
            "Regression Analysis" -> regressionanalysisquiz()
            "Sampling Techniques" -> samplingtechniqesquiz()
            "Statistical Modeling" -> statisticalmodelingquiz()
            "Experimental Design" -> experimentaldesignquiz()
            "Data Visualization" -> datavisualizationquiz()
            "Statistical Software" -> statisticalsoftwarequiz()
            "Time Series Analysis" -> timeseriesanalysisquiz()
            "Statics and Dynamics" -> staticsandynamicsquiz()
            "Thermodynamics" -> thermodynamicsquiz()
            "Fluid Mechanics" -> fluidmechanicsquiz()
            "Heat Transfer" -> heatransferquiz()
            "Materials Science" -> materialssciencquiz()
            "Mechanics of Machines" -> mechanicsofmachinesquiz()
            "Manufacturing Processes" -> manufacturingprocessesquiz()
            "Automotive Engineering" -> automativeengineeringquiz()
            "Robotics and Automation" -> roboticsandautomationquiz()
            "Engineering Design" -> engineeringdesignquiz()
            "Analog Electronics" -> analogelectronicsquiz()
            "Digital Electronics" -> digitalelectronicsquiz()
            "Microelectronics" -> microelectronicsquiz()
            "Electronic Circuits" -> electronicircuitsquiz()
            "Signal Processing" -> signalprocessingquiz()
            "Communication Systems" -> communicationsystemsquiz()
            "Power Electronics" -> powerelectronicsquiz()
            "Embedded Systems" -> embeddedsystemsquiz()
            "Control Systems" -> controlsystemsquiz()
            "VLSI Design" -> vlsidesignquiz()
            "Football" -> footballquiz()
            "Basketball" -> basketballquiz()
            "Tennis" -> tennisquiz()
            "Cricket" -> cricketquiz()
            "Golf" -> golfquiz()
            "Baseball" -> baseballquiz()
            "Swimming" -> swimmingquiz()
            "Athletics" -> athleticsquiz()
            "Volleyball" -> vollyballquiz()
            "Hockey" -> hockeyquiz()
            "Clothing Styles" -> clothingstylesquiz()
            "Fashion Trends" -> fashiontrendsquiz()
            "Fashion Designers" -> fashiondesignersquiz()
            "Fashion Accessories" -> fashionaccessoriesquiz()
            "Fashion Shows" -> fashionshowsquiz()
            "Beauty and Makeup" -> beautyandmakeupquiz()
            "Fashion Brands" -> fashionbrandsquiz()
            "Hairstyles" -> hairstylesquiz()
            "Fashion Photography" -> fashionphotographyquiz()
            "Fashion Magazines" -> fashionmagazinesquiz()
            else -> empty()
        }
        quizAdapter = QuizAdapter(this,quizlist)
        recyclerView.adapter = quizAdapter

    }
}

