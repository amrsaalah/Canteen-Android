package com.canteen.base.bindingAdapters

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import javax.inject.Inject


/**
 * Created by Amr Salah on 5/25/2019.
 */


class TextViewBindingAdapter @Inject constructor() {

    @BindingAdapter(
        value = ["firstText", "secondText", "secondColor"],
        requireAll = true
    )
    fun setTwoColorText(
        textView: TextView,
        firstText: String,
        secondText: String, @ColorRes secondColor: Int
    ) {
        val wholeText = "$firstText $secondText"
        val spannable = SpannableString(wholeText)
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(textView.context, secondColor)),
            firstText.length,
            (wholeText).length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.setText(spannable, TextView.BufferType.SPANNABLE)

    }

}