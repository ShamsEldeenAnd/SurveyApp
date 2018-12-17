package com.developer.shams.surveyapp.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.developer.shams.surveyapp.R
import com.developer.shams.surveyapp.dialog.InformationDialog
import com.developer.shams.surveyapp.utilities.EmojiAnimator
import kotlinx.android.synthetic.main.activity_main.*


var IS_ANIMATED = false


class MainActivity : AppCompatActivity() {

    private lateinit var likesList: ArrayList<String>
    private lateinit var userFeeling: String
    private val emojiAnimator = EmojiAnimator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        likesList = ArrayList()

        setTypeface()
        submit.setOnClickListener {
            if (IS_ANIMATED)
                InformationDialog(this, getUserFeeling(), getLikes()).show()
            else {
                emojiAnimator.animateEmojiUp(smile)
                emojiAnimator.animateEmojiUp(sad)
                emojiAnimator.animateEmojiDown(smile)
                emojiAnimator.animateEmojiDown(sad)
            }
        }
    }

    //setup as property in style file
    fun selectEmoji(view: View) {
        when (view.id) {
            R.id.smile -> animateEmoji(view)
            R.id.sad -> animateEmoji(view)
        }
    }

    //setup as property in style file
    fun selectCompanyActivity(view: View) {
        when (view.id) {
            R.id.help -> changeBackground(help)
            R.id.exp -> changeBackground(exp)
            R.id.cost -> changeBackground(cost)
            R.id.value -> changeBackground(value)
            R.id.response -> changeBackground(response)
        }
    }


    //change font for app
    fun setTypeface() {
        val typeface = Typeface.createFromAsset(assets, "fonts/VT323_Regular.ttf")
        header.typeface = typeface
        like.typeface = typeface
        exp.typeface = typeface
        cost.typeface = typeface
        response.typeface = typeface
        value.typeface = typeface
        help.typeface = typeface
        submit.typeface = typeface
    }


    //resbonible for  change background color
    private fun changeBackground(button: Button) {

        if (button.background.constantState == (resources.getDrawable(R.drawable.btn_background_of).constantState)) {
            button.setBackgroundResource(R.drawable.btn_background_on)
            button.setTextColor(Color.WHITE)
            button.setCompoundDrawablesWithIntrinsicBounds(
                0, 0,
                R.drawable.ic_add_white_24dp, 0
            )
            addLikes(button.text.toString())
        } else {
            button.setBackgroundResource(R.drawable.btn_background_of)
            button.setTextColor(Color.BLACK)
            button.setCompoundDrawablesWithIntrinsicBounds(
                0, 0,
                R.drawable.ic_add_black_24dp, 0
            )
            removeLikes(button.text.toString())

        }
    }


    private fun animateEmoji(view: View) {
        if (view.id == R.id.sad) {
            if (IS_ANIMATED) {
                emojiAnimator.animateEmojiUp(view)
                emojiAnimator.animateEmojiDown(smile)
                setUserFeeling("Sad")
            } else {
                emojiAnimator.animateEmojiUp(view)
                IS_ANIMATED = true
                setUserFeeling("Sad")
            }
        } else {
            if (IS_ANIMATED) {
                emojiAnimator.animateEmojiUp(view)
                emojiAnimator.animateEmojiDown(sad)
                setUserFeeling("Happy")
            } else {
                emojiAnimator.animateEmojiUp(view)
                IS_ANIMATED = true
                setUserFeeling("Happy")
            }
        }
    }


    private fun addLikes(like: String) {
        if (!likesList.contains(like))
            likesList.add(like)
    }

    private fun removeLikes(like: String) {
        if (likesList.contains(like))
            likesList.remove(like)
    }

    private fun getLikes() = likesList

    private fun setUserFeeling(feel: String) {
        userFeeling = feel
    }

    private fun getUserFeeling() = userFeeling


}
