package com.mcgars.delegate_example.core.delegat.render

import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Implements [RenderView.getView]
 */
abstract class RenderViewInflate<T>(
        @LayoutRes
        val layout: Int
) : RenderView<T> {

    override fun getView(previousView: View?, parent: ViewGroup, inflater: LayoutInflater): View {
        return inflater.inflate(layout, parent, false)
    }

}