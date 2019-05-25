package com.canteen.base.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Amr Salah on 5/25/2019.
 */

fun Fragment.showToast(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}