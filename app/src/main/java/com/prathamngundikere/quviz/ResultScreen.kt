package com.prathamngundikere.quviz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.prathamngundikere.quviz.adapter.QuizQuestionAdapter
import com.prathamngundikere.quviz.adapter.ResultAdapter
import com.prathamngundikere.quviz.datamodel.userfirebase
import com.prathamngundikere.quviz.util.accountingquiz1
import com.prathamngundikere.quviz.util.acidsandbasesquiz1
import com.prathamngundikere.quviz.util.aiquiz1
import com.prathamngundikere.quviz.util.algebraquiz1
import com.prathamngundikere.quviz.util.algorithmsquiz1
import com.prathamngundikere.quviz.util.analogelectronicsquiz1
import com.prathamngundikere.quviz.util.ancientcivilizationsquiz1
import com.prathamngundikere.quviz.util.arithmeticquiz1
import com.prathamngundikere.quviz.util.astrophysicsquiz1
import com.prathamngundikere.quviz.util.athleticsquiz1
import com.prathamngundikere.quviz.util.atomicstructurequiz1
import com.prathamngundikere.quviz.util.automotiveengineeringquiz1
import com.prathamngundikere.quviz.util.baseballquiz1
import com.prathamngundikere.quviz.util.basketballquiz1
import com.prathamngundikere.quviz.util.beautyandmakeupquiz1
import com.prathamngundikere.quviz.util.biochemistryquiz1
import com.prathamngundikere.quviz.util.biotechnologyquiz1
import com.prathamngundikere.quviz.util.buildingmaterialsandtechquiz1
import com.prathamngundikere.quviz.util.businesslawquiz1
import com.prathamngundikere.quviz.util.businessstudiesquiz1
import com.prathamngundikere.quviz.util.calculusquiz1
import com.prathamngundikere.quviz.util.cellbiologyquiz1
import com.prathamngundikere.quviz.util.chemicalbondingquiz1
import com.prathamngundikere.quviz.util.chemicalequilibriumquiz1
import com.prathamngundikere.quviz.util.citizenshipandemocracyquiz1
import com.prathamngundikere.quviz.util.civicresponsibilitiesquiz1
import com.prathamngundikere.quviz.util.civilrightsmovementquiz1
import com.prathamngundikere.quviz.util.climateandweatherquiz1
import com.prathamngundikere.quviz.util.clothingstylesquiz1
import com.prathamngundikere.quviz.util.coldwarquiz1
import com.prathamngundikere.quviz.util.colonialismquiz1
import com.prathamngundikere.quviz.util.communicationsystemsquiz1
import com.prathamngundikere.quviz.util.computernetworksquiz1
import com.prathamngundikere.quviz.util.constitutionrightsquiz1
import com.prathamngundikere.quviz.util.constructionmanagementquiz1
import com.prathamngundikere.quviz.util.controlsystemsquiz1
import com.prathamngundikere.quviz.util.cricketquiz1
import com.prathamngundikere.quviz.util.culturalgeographyquiz1
import com.prathamngundikere.quviz.util.cybersecurityquiz1
import com.prathamngundikere.quviz.util.databasesquiz1
import com.prathamngundikere.quviz.util.datastructurequiz1
import com.prathamngundikere.quviz.util.datavisualizationquiz1
import com.prathamngundikere.quviz.util.decolonizationquiz1
import com.prathamngundikere.quviz.util.descriptivestatisticsquiz1
import com.prathamngundikere.quviz.util.differentialequationsquiz1
import com.prathamngundikere.quviz.util.digitalelectronicsquiz1
import com.prathamngundikere.quviz.util.ecologyquiz1
import com.prathamngundikere.quviz.util.economicsquiz1
import com.prathamngundikere.quviz.util.electionsandvotingquiz1
import com.prathamngundikere.quviz.util.electromagnetismquiz1
import com.prathamngundikere.quviz.util.electroniccircuitsquiz1
import com.prathamngundikere.quviz.util.embeddedsystemsquiz1
import com.prathamngundikere.quviz.util.engineeringdesignquiz1
import com.prathamngundikere.quviz.util.entrepreneurshipquiz1
import com.prathamngundikere.quviz.util.environmentalengineeringquiz1
import com.prathamngundikere.quviz.util.environmentalgeographyquiz1
import com.prathamngundikere.quviz.util.evolutionquiz1
import com.prathamngundikere.quviz.util.experimentaldesignquiz1
import com.prathamngundikere.quviz.util.fashionaccessoriesquiz1
import com.prathamngundikere.quviz.util.fashionbrandsquiz1
import com.prathamngundikere.quviz.util.fashiondesignersquiz1
import com.prathamngundikere.quviz.util.fashionmagazinesquiz1
import com.prathamngundikere.quviz.util.fashionphotographyquiz1
import com.prathamngundikere.quviz.util.fashionshowsquiz1
import com.prathamngundikere.quviz.util.fashiontrendsquiz1
import com.prathamngundikere.quviz.util.financequiz1
import com.prathamngundikere.quviz.util.financialmanagementquiz1
import com.prathamngundikere.quviz.util.fluidmechanicsquiz1
import com.prathamngundikere.quviz.util.footballquiz1
import com.prathamngundikere.quviz.util.geneticsquiz1
import com.prathamngundikere.quviz.util.geometryquiz1
import com.prathamngundikere.quviz.util.geotechnicalengineeringquiz1
import com.prathamngundikere.quviz.util.gisquiz1
import com.prathamngundikere.quviz.util.globalizationquiz1
import com.prathamngundikere.quviz.util.golfquiz1
import com.prathamngundikere.quviz.util.hairstylesquiz1
import com.prathamngundikere.quviz.util.heattransferquiz1
import com.prathamngundikere.quviz.util.hockeyquiz1
import com.prathamngundikere.quviz.util.humananatomyquiz1
import com.prathamngundikere.quviz.util.humangeographyquiz1
import com.prathamngundikere.quviz.util.humanrightsquiz1
import com.prathamngundikere.quviz.util.hypothesistestingquiz1
import com.prathamngundikere.quviz.util.immunologyquiz1
import com.prathamngundikere.quviz.util.industrialrevolutionquiz1
import com.prathamngundikere.quviz.util.infrastructuredevelopmentquiz1
import com.prathamngundikere.quviz.util.internationalrelationsquiz1
import com.prathamngundikere.quviz.util.internationaltradequiz1
import com.prathamngundikere.quviz.util.landformsandbiomesquiz1
import com.prathamngundikere.quviz.util.lawandjusticequiz1
import com.prathamngundikere.quviz.util.linearalgebraquiz1
import com.prathamngundikere.quviz.util.manufacturingprocessquiz1
import com.prathamngundikere.quviz.util.marketingquiz1
import com.prathamngundikere.quviz.util.materialsciencequiz1
import com.prathamngundikere.quviz.util.mathematicallogicquiz1
import com.prathamngundikere.quviz.util.mechanicsofmachinesquiz1
import com.prathamngundikere.quviz.util.mechanicsquiz1
import com.prathamngundikere.quviz.util.microbiologyquiz1
import com.prathamngundikere.quviz.util.microelectronicsquiz1
import com.prathamngundikere.quviz.util.naturalresourcesquiz1
import com.prathamngundikere.quviz.util.nuclearphysicsquiz1
import com.prathamngundikere.quviz.util.numbertheoryquiz1
import com.prathamngundikere.quviz.util.oopquiz1
import com.prathamngundikere.quviz.util.operatingsystemsquiz1
import com.prathamngundikere.quviz.util.opticsquiz1
import com.prathamngundikere.quviz.util.organichemistryquiz1
import com.prathamngundikere.quviz.util.particlephysicsquiz1
import com.prathamngundikere.quviz.util.periodictablequiz1
import com.prathamngundikere.quviz.util.physicalgeographyquiz1
import com.prathamngundikere.quviz.util.physiologyquiz1
import com.prathamngundikere.quviz.util.planbiologyquiz2
import com.prathamngundikere.quviz.util.plantBiologyQuiz3
import com.prathamngundikere.quviz.util.plantBiologyQuiz4
import com.prathamngundikere.quviz.util.plantBiologyQuiz5
import com.prathamngundikere.quviz.util.plantBiologyQuiz6
import com.prathamngundikere.quviz.util.plantbiologyquiz1
import com.prathamngundikere.quviz.util.politicalsystemsquiz1
import com.prathamngundikere.quviz.util.populationandmigrationquiz1
import com.prathamngundikere.quviz.util.powerelectronicsquiz1
import com.prathamngundikere.quviz.util.probabilitydistributionsquiz1
import com.prathamngundikere.quviz.util.probabilityquiz1
import com.prathamngundikere.quviz.util.programmingconceptsquiz1
import com.prathamngundikere.quviz.util.publicpolicyquiz1
import com.prathamngundikere.quviz.util.quantumechanicsquiz1
import com.prathamngundikere.quviz.util.quizscore
import com.prathamngundikere.quviz.util.redoxreactionsquiz1
import com.prathamngundikere.quviz.util.regressionanalysisquiz1
import com.prathamngundikere.quviz.util.relativityquiz1
import com.prathamngundikere.quviz.util.renaissancequiz1
import com.prathamngundikere.quviz.util.revolutionarymovementsquiz1
import com.prathamngundikere.quviz.util.roboticsandautomationquiz1
import com.prathamngundikere.quviz.util.samplingtechniquesquiz1
import com.prathamngundikere.quviz.util.selectedlist
import com.prathamngundikere.quviz.util.signalprocessingquiz1
import com.prathamngundikere.quviz.util.statesofmatterquiz1
import com.prathamngundikere.quviz.util.staticsanddynamicsquiz1
import com.prathamngundikere.quviz.util.statisticalmodelingquiz1
import com.prathamngundikere.quviz.util.statisticalsoftwarequiz1
import com.prathamngundikere.quviz.util.stochiometryquiz1
import com.prathamngundikere.quviz.util.structuralengineeringquiz1
import com.prathamngundikere.quviz.util.supplychainmanagementquiz1
import com.prathamngundikere.quviz.util.surveyingandmappingquiz1
import com.prathamngundikere.quviz.util.swimmingquiz1
import com.prathamngundikere.quviz.util.tennisquiz1
import com.prathamngundikere.quviz.util.thermodynamicschemistryquiz1
import com.prathamngundikere.quviz.util.thermodynamicsphysicsquiz1
import com.prathamngundikere.quviz.util.thermodynamicsquiz1
import com.prathamngundikere.quviz.util.timeseriesanalysisquiz1
import com.prathamngundikere.quviz.util.transportationengineeringquiz1
import com.prathamngundikere.quviz.util.trigonometryquiz1
import com.prathamngundikere.quviz.util.typesofgovernmentquiz1
import com.prathamngundikere.quviz.util.urbanplanningquiz1
import com.prathamngundikere.quviz.util.vlsidesignquiz1
import com.prathamngundikere.quviz.util.volleyballquiz1
import com.prathamngundikere.quviz.util.waterresouceengineeringquiz1
import com.prathamngundikere.quviz.util.wavesoscillationsquiz1
import com.prathamngundikere.quviz.util.webdevelopmentquiz1
import com.prathamngundikere.quviz.util.worldgeographyquiz1
import com.prathamngundikere.quviz.util.worldwarsquiz1
import java.util.Calendar

class ResultScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var ResultAdapter: ResultAdapter
    private lateinit var QuizName: String
    private lateinit var TimeTaken:String
    private lateinit var PresentTime:String
    private lateinit var UserScore:String
    private lateinit var UserID:String
    private lateinit var DBref:DatabaseReference
    private lateinit var QuizID:String
    private var TotalScore:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        val score : TextView = findViewById(R.id.tv_score)
        val finish : Button = findViewById(R.id.btn_finish)
        val quizName = intent.getStringExtra("quizname")
        val questionlists = when (quizName) {
            "Plant Biology Quiz 1" -> plantbiologyquiz1()
            "Plant Biology Quiz 2" -> planbiologyquiz2()
            "Plant Biology Quiz 3" -> plantBiologyQuiz3()
            "Plant Biology Quiz 4" -> plantBiologyQuiz4()
            "Plant Biology Quiz 5" -> plantBiologyQuiz5()
            "Plant Biology Quiz 6" -> plantBiologyQuiz6()
            "OOP Quiz 1" -> oopquiz1()
            "Data Structure Quiz 1" -> datastructurequiz1()
            "Cyber Security Quiz 1" -> cybersecurityquiz1()
            "Web Development Quiz 1" -> webdevelopmentquiz1()
            "Computer Networks Quiz 1" -> computernetworksquiz1()
            "AI Quiz 1" -> aiquiz1()
            "Programming Quiz 1" -> programmingconceptsquiz1()
            "Database Quiz 1" -> databasesquiz1()
            "OS Quiz 1" -> operatingsystemsquiz1()
            "Algorithm Quiz 1" -> algorithmsquiz1()
            "Atomic Structure Quiz 1" -> atomicstructurequiz1()
            "Chemical Bonding Quiz 1" -> chemicalbondingquiz1()
            "Periodic Table Quiz 1" -> periodictablequiz1()
            "Stoichiometry Quiz 1" -> stochiometryquiz1()
            "States of Matter Quiz 1" -> statesofmatterquiz1()
            "Acid and Bases Quiz 1" -> acidsandbasesquiz1()
            "Redox Reactions Quiz 1" -> redoxreactionsquiz1()
            "Organic Chemistry Quiz 1" -> organichemistryquiz1()
            "Thermodynamic Chem... Quiz 1" -> thermodynamicschemistryquiz1()
            "Chemical Equilibrium Quiz 1" -> chemicalequilibriumquiz1()
            "Geotechnical Engineering Quiz 1" -> geotechnicalengineeringquiz1()
            "Surveying Quiz 1" -> surveyingandmappingquiz1()
            "Eco-Engineering Quiz 1" -> environmentalengineeringquiz1()
            "Structural Engineering Quiz 1" -> structuralengineeringquiz1()
            "Building Materials Quiz 1" -> buildingmaterialsandtechquiz1()
            "Urban Planning Quiz 1" -> urbanplanningquiz1()
            "Water Resource Engi... Quiz 1" -> waterresouceengineeringquiz1()
            "Infrastructure Development Quiz 1" -> infrastructuredevelopmentquiz1()
            "Construction Management Quiz 1" -> constructionmanagementquiz1()
            "Transportation Engineering Quiz 1" -> transportationengineeringquiz1()
            "Mechanics Quiz 1" -> mechanicsquiz1()
            "Thermodynamic Physics Quiz 1" -> thermodynamicsphysicsquiz1()
            "Electromagnetism Quiz 1" -> electromagnetismquiz1()
            "Optics Quiz 1" -> opticsquiz1()
            "Waves and Oscillations Quiz 1" -> wavesoscillationsquiz1()
            "Quantum Mechanics Quiz 1" -> quantumechanicsquiz1()
            "Relativity Quiz 1" -> relativityquiz1()
            "Nuclear Physics Quiz 1" -> nuclearphysicsquiz1()
            "Particle Physics Quiz 1" -> particlephysicsquiz1()
            "Astrophysics Quiz 1" -> astrophysicsquiz1()
            "Cell Biology Quiz 1" -> cellbiologyquiz1()
            "Genetics Quiz 1" -> geneticsquiz1()
            "Ecology Quiz 1" -> ecologyquiz1()
            "Human Anatomy Quiz 1" -> humananatomyquiz1()
            "Physiology Quiz 1" -> physiologyquiz1()
            "Microbiology Quiz 1" -> microbiologyquiz1()
            "Biochemistry Quiz 1" -> biochemistryquiz1()
            "Immunology Quiz 1" -> immunologyquiz1()
            "Biotechnology Quiz 1" -> biotechnologyquiz1()
            "Evolution Quiz 1" -> evolutionquiz1()
            "Arithmetics Quiz 1" -> arithmeticquiz1()
            "Algebra Quiz 1" -> algebraquiz1()
            "Geometry Quiz 1" -> geometryquiz1()
            "Trigonometry Quiz 1" -> trigonometryquiz1()
            "Calculus Quiz 1" -> calculusquiz1()
            "Probability Quiz 1" -> probabilityquiz1()
            "Number Theory Quiz 1" -> numbertheoryquiz1()
            "Linear Algebra Quiz 1" -> linearalgebraquiz1()
            "Differential Equations Quiz 1" -> differentialequationsquiz1()
            "Mathematical Logic Quiz 1" -> mathematicallogicquiz1()
            "Ancient Civilizations Quiz 1" -> ancientcivilizationsquiz1()
            "World Wars QUiz 1" -> worldwarsquiz1()
            "Renaissance Quiz 1" -> renaissancequiz1()
            "Colonialism Quiz 1" -> colonialismquiz1()
            "Industrial Revolution Quiz 1" -> industrialrevolutionquiz1()
            "Cold Wars Quiz 1" -> coldwarquiz1()
            "Civil Rights Movement Quiz 1" -> civilrightsmovementquiz1()
            "Globalization Quiz 1" -> globalizationquiz1()
            "Revolutionary Movements Quiz 1" -> revolutionarymovementsquiz1()
            "Decolonization Quiz 1" -> decolonizationquiz1()
            "Types of Government Quiz 1" -> typesofgovernmentquiz1()
            "Constitutions and Rights Quiz 1" -> constitutionrightsquiz1()
            "Citizenship and Democracy Quiz 1" -> citizenshipandemocracyquiz1()
            "Political Systems Quiz 1" -> politicalsystemsquiz1()
            "Law and Justice Quiz 1" -> lawandjusticequiz1()
            "Elections and Voting Quiz 1" -> electionsandvotingquiz1()
            "Public Policy Quiz 1" -> publicpolicyquiz1()
            "International Relations Quiz 1" -> internationalrelationsquiz1()
            "Human Rights Quiz 1" -> humanrightsquiz1()
            "Civic Responsibility Quiz 1" -> civicresponsibilitiesquiz1()
            "Physical Geography Quiz 1" -> physicalgeographyquiz1()
            "Human Geography Quiz 1" -> humangeographyquiz1()
            "World Geography Quiz 1" -> worldgeographyquiz1()
            "Cultural Geography Quiz 1" -> culturalgeographyquiz1()
            "Environmental Geography Quiz 1" -> environmentalgeographyquiz1()
            "GIS Quiz 1" -> gisquiz1()
            "Population and Migration Quiz 1" -> populationandmigrationquiz1()
            "Landforms and Biomes Quiz 1" -> landformsandbiomesquiz1()
            "Climate and Weather Quiz 1" -> climateandweatherquiz1()
            "Natural Resources Quiz 1" -> naturalresourcesquiz1()
            "Business Studies Quiz 1" -> businessstudiesquiz1()
            "Accounting Quiz 1" -> accountingquiz1()
            "Economics Quiz 1" -> economicsquiz1()
            "Marketing Quiz 1" -> marketingquiz1()
            "Finance Quiz 1" -> financequiz1()
            "Entrepreneurship Quiz 1" -> entrepreneurshipquiz1()
            "Supply Chain Management Quiz 1" -> supplychainmanagementquiz1()
            "International Trade Quiz 1" -> internationaltradequiz1()
            "Business Quiz 1" -> businesslawquiz1()
            "Financial Management Quiz 1" -> financialmanagementquiz1()
            "Descriptive Statistics Quiz 1" -> descriptivestatisticsquiz1()
            "Probability Distributions Quiz 1" -> probabilitydistributionsquiz1()
            "Hypothesis Testing Quiz 1" -> hypothesistestingquiz1()
            "Regression Analysis Quiz 1" -> regressionanalysisquiz1()
            "Sampling Techniques Quiz 1" -> samplingtechniquesquiz1()
            "Statistical Modeling Quiz 1" -> statisticalmodelingquiz1()
            "Experimental Design Quiz 1" -> experimentaldesignquiz1()
            "Data Visualization Quiz 1" -> datavisualizationquiz1()
            "Statistical Software Quiz 1" -> statisticalsoftwarequiz1()
            "Time Series Analysis Quiz 1" -> timeseriesanalysisquiz1()
            "Statics and Dynamics Quiz 1" -> staticsanddynamicsquiz1()
            "Thermodynamics Quiz 1" -> thermodynamicsquiz1()
            "Fluid Mechanics Quiz 1" -> fluidmechanicsquiz1()
            "Heat Transfer Quiz 1" -> heattransferquiz1()
            "Material Science Quiz 1" -> materialsciencequiz1()
            "Mechanics of Machines Quiz 1" -> mechanicsofmachinesquiz1()
            "Manufacturing Processes Quiz 1" -> manufacturingprocessquiz1()
            "Automotive Engineering Quiz 1" -> automotiveengineeringquiz1()
            "Robotics and Automation Quiz 1" -> roboticsandautomationquiz1()
            "Engineering Design Quiz 1" -> engineeringdesignquiz1()
            "Analog Electronics Quiz 1" -> analogelectronicsquiz1()
            "Digital Electronics Quiz 1" -> digitalelectronicsquiz1()
            "Microelectronics Quiz 1" -> microelectronicsquiz1()
            "Electronic Circuits Quiz 1" -> electroniccircuitsquiz1()
            "Signal Processing Quiz 1" -> signalprocessingquiz1()
            "Communication Systems Quiz 1" -> communicationsystemsquiz1()
            "Power Electronics Quiz 1" -> powerelectronicsquiz1()
            "Embedded Systems Quiz 1" -> embeddedsystemsquiz1()
            "Control Systems Quiz 1" -> controlsystemsquiz1()
            "VLSI Design Quiz 1" -> vlsidesignquiz1()
            "Football Quiz 1" -> footballquiz1()
            "Basketball Quiz 1" -> basketballquiz1()
            "Tennis Quiz 1" -> tennisquiz1()
            "Cricket Quiz 1" -> cricketquiz1()
            "Golf Quiz 1" -> golfquiz1()
            "Baseball Quiz 1" -> baseballquiz1()
            "Swimming Quiz 1" -> swimmingquiz1()
            "Athletics Quiz 1" -> athleticsquiz1()
            "Volleyball Quiz 1" -> volleyballquiz1()
            "Hockey Quiz 1" -> hockeyquiz1()
            "Clothing Style Quiz 1" -> clothingstylesquiz1()
            "Fashion Trends Quiz 1" -> fashiontrendsquiz1()
            "Fashion Designer Quiz 1" -> fashiondesignersquiz1()
            "Fashion Accessories Quiz 1" -> fashionaccessoriesquiz1()
            "Fashion Shows Quiz 1" -> fashionshowsquiz1()
            "Beauty Makeup Quiz 1" -> beautyandmakeupquiz1()
            "Fashion Brands Quiz 1" -> fashionbrandsquiz1()
            "Hairstyle Quiz 1" -> hairstylesquiz1()
            "Fashion Photography Quiz 1" -> fashionphotographyquiz1()
            "Fashion Magazines Quiz 1" -> fashionmagazinesquiz1()
            else -> plantbiologyquiz1()
        }
        recyclerView = findViewById(R.id.result_rv)
        ResultAdapter = ResultAdapter(questionlists)
        recyclerView.adapter = ResultAdapter
        for (i in 0 until 10) {
            val list = questionlists[i]
            if (list.correctAnswer == selectedlist[i]){
                quizscore += 1
            }
        }
        score.text = "$quizscore/10"
        //***********************************************************************
        val sharedPreferences = getSharedPreferences("QuizPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var  totalscoreq = sharedPreferences.getInt("totalscore", 0)
        totalscoreq += quizscore
        editor.putInt("totalscore",totalscoreq)
        editor.apply()
        //*************************************************************************************
        //Initiating Firebase protocol
        val user = FirebaseAuth.getInstance().currentUser
        QuizName = quizName.toString()
        TimeTaken = intent.getStringExtra("timetaken").toString()
        PresentTime = getCurrentTimeUsingCalendar().toString()
        UserScore = quizscore.toString()
        UserID = user?.uid.toString()
        TotalScore = totalscoreq
        DBref = FirebaseDatabase.getInstance().getReference("$UserID")
        QuizID = DBref.push().key!!

        finish.setOnClickListener {
            selectedlist = intArrayOf(0,0,0,0,0,0,0,0,0,0)
            quizscore = 0
            val userFB = userfirebase(QuizName,QuizID,TimeTaken,PresentTime,UserScore)
            DBref.child(QuizID).setValue(userFB)
                .addOnCompleteListener{
                    Toast.makeText(this, "Data Added Successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Data not added successfully ${err}", Toast.LENGTH_SHORT).show()
                }
            super.onBackPressed()
            Toast.makeText(this, "Take another Quiz", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    fun getCurrentTimeUsingCalendar(): String {
        val currentTime = Calendar.getInstance()
        val hour = currentTime.get(Calendar.HOUR_OF_DAY)
        val minute = currentTime.get(Calendar.MINUTE)
        val day =  currentTime.get(Calendar.DAY_OF_MONTH)
        val month = currentTime.get(Calendar.MONTH)
        val year = currentTime.get(Calendar.YEAR)
        // Format the time as a string (e.g., "HH:mm")
        return String.format("%02d/%02d/%02d-%02d:%02d",day,month,year,hour,minute)
    }
    override fun onBackPressed(){
        selectedlist = intArrayOf(0,0,0,0,0,0,0,0,0,0)
        quizscore = 0
        val userFB = userfirebase(QuizName,QuizID,TimeTaken,PresentTime,UserScore)
        DBref.child(QuizID).setValue(userFB)
            .addOnCompleteListener{
                Toast.makeText(this, "Data Added Successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { err ->
                Toast.makeText(this, "Data not added successfully ${err}", Toast.LENGTH_SHORT).show()
            }
        super.onBackPressed()
        Toast.makeText(this, "Take another Quiz", Toast.LENGTH_SHORT).show()
        finish()
    }
}
