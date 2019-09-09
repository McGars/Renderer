package com.mcgars.delegate_example.core.delegat.render

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder

/**
 * Created by gars on 01.11.17.
 */
interface RenderView<T> {

    /**
     * Create view and can decorate [previousView]
     */
    fun getView(previousView: View?, parent: ViewGroup, inflater: LayoutInflater): View

    /**
     * Bind values
     */
    fun bindView(item: T, vh: RenderViewHolder)

    /**
     * Attach clicks
     */
    fun attachClick(kitAdapter: KitAdapter<T>, vh: RenderViewHolder) {}


    fun onViewRecycled(vh: RenderViewHolder) {}

    /**
     * View detached
     */
    fun onViewDetachedFromWindow(vh: RenderViewHolder) {}
}