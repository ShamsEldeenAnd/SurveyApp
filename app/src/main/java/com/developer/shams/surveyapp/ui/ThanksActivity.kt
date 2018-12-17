package com.developer.shams.surveyapp.ui

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.shams.surveyapp.R
import kotlinx.android.synthetic.main.activity_thanks.*

class ThanksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)
        setTypeface()

        bye.setOnClickListener { finish() }
    }

    private fun setTypeface() {
        val typeface = Typeface.createFromAsset(assets, "fonts/VT323_Regular.ttf")
        bye.typeface = typeface

    }


}
