package com.developer.shams.surveyapp.utilities

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

const val DEFAULT_ANIMATION_DURATION = 500L

class EmojiAnimator {



    fun animateEmojiUp(view: View) {
        val animation =
            ScaleAnimation(
                1f, 1.1f, 1f, 1.1f
                , Animation.RELATIVE_TO_SELF
                , 0.5f, Animation.RELATIVE_TO_SELF
                , 0.5f
            )
        animation.duration = DEFAULT_ANIMATION_DURATION
        animation.fillAfter = true
        view.startAnimation(animation)

    }

    fun animateEmojiDown(view: View) {
        val animation =
            ScaleAnimation(
                1.1f, 1f, 1.1f, 1f
                , Animation.RELATIVE_TO_SELF
                , 0.5f, Animation.RELATIVE_TO_SELF
                , 0.5f
            )
        animation.duration = DEFAULT_ANIMATION_DURATION
        animation.fillAfter = true
        view.startAnimation(animation)
    }

}