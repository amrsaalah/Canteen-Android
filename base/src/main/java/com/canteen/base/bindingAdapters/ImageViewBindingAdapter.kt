package com.canteen.base.bindingAdapters

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.canteen.base.extensions.hide
import com.canteen.base.extensions.show
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Amr Salah on 6/6/2019.
 */
class ImageViewBindingAdapter @Inject constructor() {

    @BindingAdapter(
        value = ["imgUrl", "placeholder"],
        requireAll = false
    )
    fun setImageFromUrl(
        imageView: ImageView,
        imgUrl: String?,
        @DrawableRes placeholder: Int?
    ) {

        val requestOptions = if (placeholder != null) {
            RequestOptions().error(placeholder).placeholder(placeholder)
        } else {
            RequestOptions()
        }

        Glide.with(imageView.context).load(imgUrl).apply(requestOptions).into(imageView)
    }


    @BindingAdapter("android:visibility")
    fun setProgressVisibility(progressBar: ProgressBar, isVisible: Boolean?) {
        Timber.d("$isVisible")
        if (isVisible != null) {
            if (isVisible) {
                progressBar.show()
            } else {
                progressBar.hide()
            }
        } else {
            progressBar.hide()
        }
    }

    @BindingAdapter("drawableSrc")
    fun setDrawable(imageView: ImageView, @DrawableRes drawable: Int) {
        val myDrawable = imageView.context.getDrawable(drawable)
        imageView.setImageDrawable(myDrawable)
    }
}