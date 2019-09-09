package com.mcgars.delegate_example.core.delegat.render

import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder

/**
 * Create ViewHolder with [layout]
 *
 * Call [RenderView.bindView] and [RenderView.attachClick] for all [array] render
 * without call [RenderView.getView]
 */
class RenderViewContainer<T>(
        layout: Int,
        vararg array: RenderView<T>
) : RenderViewInflate<T>(layout) {

    val renders = mutableListOf<RenderView<T>>()

    init {
        renders.addAll(array)
    }

    fun add(render: RenderView<T>) {
        renders.add(render)
    }

    override fun bindView(item: T, vh: RenderViewHolder) {
        renders.forEach { it.bindView(item, vh) }
    }

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