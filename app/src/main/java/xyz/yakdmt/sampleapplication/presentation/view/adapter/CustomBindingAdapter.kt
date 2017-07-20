package xyz.yakdmt.sampleapplication.presentation.view.adapter

import android.databinding.BindingAdapter
import android.view.View

/**
 * Created by yakdmt on 19/07/2017.
 */
class CustomBindingAdapter {

    companion object {
        @JvmStatic @BindingAdapter("visibleGone")
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

}