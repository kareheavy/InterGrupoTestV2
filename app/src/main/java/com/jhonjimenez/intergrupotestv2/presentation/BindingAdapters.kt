package com.jhonjimenez.intergrupotestv2.presentation

import android.view.View
import android.widget.CheckBox
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("isVisible")
fun isVisible(view: View, visibilty: Boolean) {
    view.visibility = if (visibilty) View.VISIBLE else View.GONE
}

@BindingAdapter("isEnabled")
fun isEnabled(view: View, isEnabled: Boolean) {
    view.isEnabled = isEnabled
}

@BindingAdapter("isChecked")
fun isChecked(view: CheckBox, isChecked: Boolean) {
    view.isChecked = isChecked
}

@BindingAdapter("errorInputLayout")
fun errorInputLayout(view: TextInputLayout, error: String?){
    view.error = error
}