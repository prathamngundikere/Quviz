package com.prathamngundikere.quviz.datamodel

data class question(
    val id: Int,
    val questions: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int,
    val explaination:String,
)
