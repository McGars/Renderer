package com.mcgars.delegate_example.core.delegat.render

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder

/**
 * Composite pattern
 */
class RenderLooperContainer<T>(
        vararg array: RenderView<T>
) : RenderView<T> {

    /**
     * Collections of renders
     */
    val renders = mutableListOf<RenderView<T>>().apply {
        addAll(array)
    }

    /*
     * Create view
     */
    override fun getView(previousView: View?, parent: ViewGroup, inflater: LayoutInflater): View {
        var view: View? = null

        renders.forEach {
            view = it.getView(view, parent, inflater)
        }

        return view ?: throw RuntimeException("no one of renders not create the view")
    }

    /*
     * Bind values
     */
    override fun bindView(item: T, vh: RenderViewHolder) {
        renders.forEach { it.bindView(item, vh) }
    }

    /*
     * Attach click
     */
    override fun attachClick(kitAdapter: KitAdapter<T>, vh: RenderViewHolder) {
        renders.forEach { it.attachClick(kitAdapter, vh) }
    }

    /*
    * Detach all event listeners
    * */
    override fun onViewDetachedFromWindow(vh: RenderViewHolder) {
        renders.forEach { it.onViewDetachedFromWindow(vh) }
    }

    override fun onViewRecycled(vh: RenderViewHolder) {
        renders.forEach { it.onViewRecycled(vh) }
    }
}