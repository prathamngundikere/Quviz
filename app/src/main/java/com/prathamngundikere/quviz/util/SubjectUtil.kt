package com.prathamngundikere.quviz.util

import com.prathamngundikere.quviz.datamodel.Subject

fun getSubjectsList(): List<Subject> {
    val list = mutableListOf<Subject>()
    val biologyTopics = BiologyTopics()
    val chemistryTopics = ChemistryTopics()
    val physicsTopics = PhysicsTopics()
    val mathematicsTopics = MathematicsTopics()
    val computerScienceTopics = ComputerScienceTopics()
    val historyTopics = HistoryTopics()
    val civicsTopics = CivicsTopics()
    val geographyTopics = GeographyTopics()
    val commerceTopics = CommerceTopics()
    val statisticsTopics = StatisticsTopics()
    val mechanicalTopics = MechanicalTopics()
    val civilTopics = CivilTopics()
    val electronicsTopics = ElectronicsTopics()
    val moviesTopics = MoviesTopics()
    val sportsTopics = SportsTopics()
    val currentAffairsTopics = CurrentAffairsTopics()
    val fashionTopics = FashionTopics()
    // Add more subjects and their topics here...
    list.add(Subject("Biology", biologyTopics))
    list.add(Subject("Chemistry", chemistryTopics))
    list.add(Subject("Physics", physicsTopics))
    list.add(Subject("Mathematics", mathematicsTopics))
    list.add(Subject("Computer Science", computerScienceTopics))
    list.add(Subject("History", historyTopics))
    list.add(Subject("Civics", civicsTopics))
    list.add(Subject("Geography", geographyTopics))
    list.add(Subject("Commerce", commerceTopics))
    list.add(Subject("Statistics", statisticsTopics))
    list.add(Subject("Mechanical", mechanicalTopics))
    list.add(Subject("Civil", civilTopics))
    list.add(Subject("Electronics", electronicsTopics))
    list.add(Subject("Sports", sportsTopics))
    list.add(Subject("Fashion", fashionTopics))
    // Add more subjects here...
    return list
}
