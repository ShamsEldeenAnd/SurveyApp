package com.developer.shams.surveyapp.firebase

import android.content.Context
import android.content.Intent
import com.developer.shams.surveyapp.model.UserInformation
import com.developer.shams.surveyapp.ui.ThanksActivity
import com.google.firebase.database.FirebaseDatabase

class FirebaseOperation(context: Context) {

    private var ref = FirebaseDatabase.getInstance().getReference("users")
    private var userid: String? = ""
    private var context: Context? = null

    init {
        userid = ref.push().key
        this.context = context
    }

    fun saveUser(
        useremail: String,
        userphone: String,
        usercomment: String,
        userfeel: String,
        userlikes: ArrayList<String>
    ) {
        val userInformation = UserInformation(useremail, userphone, usercomment, userfeel, userlikes)
        ref.child(userid!!).setValue(userInformation).addOnSuccessListener {
            val intent = Intent(context, ThanksActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context!!.startActivity(intent)
        }
    }

}