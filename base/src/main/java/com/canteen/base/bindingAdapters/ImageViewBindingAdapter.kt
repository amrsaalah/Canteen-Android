package com.canteen.base.bindingAdapters

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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

}