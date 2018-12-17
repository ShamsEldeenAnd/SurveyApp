package com.developer.shams.surveyapp.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.developer.shams.surveyapp.R
import com.developer.shams.surveyapp.firebase.FirebaseOperation
import kotlinx.android.synthetic.main.information_dialoug.*


class InformationDialog(context: Context, userFeeling: String, userLikes: ArrayList<String>) : Dialog(context) {

    private var operation: FirebaseOperation? = null
    private var userFeeling: String? = ""
    private var userLikes: ArrayList<String>

    init {
        this.userFeeling = userFeeling
        this.userLikes = userLikes
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.information_dialoug)

        window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawable(context.resources.getDrawable(R.drawable.btn_background_of))
        setCanceledOnTouchOutside(true)

        operation = FirebaseOperation(context)

        //basic validate info and setup firebase
        submitBtn.setOnClickListener {
            if (email.text.toString().trim().isEmpty())
                email.error = "Please Fill Your Email"
            else if (phone.text.toString().trim().isEmpty())
                email.error = "Please Fill Your Phone"
            else {
                operation!!.saveUser(
                    email.text.toString().trim()
                    , phone.text.toString().trim()
                    , comment.text.toString(), userFeeling!!, userLikes
                )

                dismiss()
            }
        }

        //close survey
        bustBtn.setOnClickListener {
            dismiss()
        }

        setupTypeface()
    }

    private fun setupTypeface() {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/VT323_Regular.ttf")
        email.typeface = typeface
        phone.typeface = typeface
        comment.typeface = typeface
        submitBtn.typeface = typeface
        bustBtn.typeface = typeface
        leave_info_txt.typeface = typeface
    }


}