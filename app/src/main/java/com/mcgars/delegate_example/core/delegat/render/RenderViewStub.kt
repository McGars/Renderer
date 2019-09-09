package com.mcgars.delegate_example.core.delegat.render

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder

/**
 * Render for stub implementation
 */
open class RenderViewStub<T> : RenderView<T> {

    override fun getView(previousView: View?, parent: ViewGroup, inflater: LayoutInflater): View {
        return previousView ?: throw IllegalStateException("set this render after all others")
    }

    override fun bindView(item: T, vh: RenderViewHolder) = Unit
}