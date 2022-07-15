package com.tringapps.forms.model

data class User(
    val userId:Int,
    val firstName:String,
    val lastName:String,
    val emailId:String,
    val password:String,
    val role:Role)
