package com.jhonjimenez.intergrupotestv2

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun isVisible(view: View, visibilty: Boolean) {
    view.visibility = if (visibilty) View.VISIBLE else View.GONE
}