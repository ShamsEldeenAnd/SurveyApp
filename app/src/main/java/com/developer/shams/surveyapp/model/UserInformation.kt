package com.developer.shams.surveyapp.model

data class UserInformation(
    var useremail: String? = "",
    var userphone: String? = "",
    var usercomment:String?="",
    var userfeel: String? = "",//happy or sad
    var userlikes: ArrayList<String>
    )
