package com.mcgars.delegate_example.core.delegat.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mcgars.basekitk.features.recycler2.AbsListItemAdapterDelegate
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.delegate_example.core.delegat.render.RenderView

open class Renderer<T : Any> : AbsListItemAdapterDelegate<T, Any, RecyclerView.ViewHolder> {

    private val render: RenderView<T>
    private var clazz: Class<T>? = null
    private var condition: RenderCondition? = null

    constructor(render: RenderView<T>, clazz: Class<T>)  {
        this.render = render
        this.clazz = clazz
    }

    constructor(render: RenderView<T>, condition: RenderCondition) {
        this.render = render
        this.condition = condition
    }

    companion object {
        inline fun <reified T : Any> create(render: RenderView<T>): Renderer<T> {
            return Renderer(render, T::class.java)
        }

        fun <T : Any> create(render: RenderView<T>, condition: RenderCondition): Renderer<T> {
            return Renderer(render, condition)
        }
    }

    override fun isForViewType(item: Any, items: List<Any>, position: Int) = condition?.invoke(item)
            ?: clazz?.isAssignableFrom(item.javaClass) ?: false

    /*
     * Bind
     */
    override fun onBindViewHolder(item: T, viewHolder: RecyclerView.ViewHolder) = render.bindView(item, viewHolder as RenderViewHolder)

    /*
     * Create holder
     */
    override fun onCreateViewHolder(kitAdapter: KitAdapter<Any>, parent: ViewGroup): RecyclerView.ViewHolder {
        return RenderViewHolder(render.getView(null, parent, LayoutInflater.from(parent.context))).apply {
            render.attachClick(kitAdapter as KitAdapter<T>, this)
        }
    }

    override fun onViewAttachedToWindow(kitAdapter: KitAdapter<Any>, holder: RecyclerView.ViewHolder) {
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        render.onViewDetachedFromWindow(holder as RenderViewHolder)
    }

}

inline fun <reified T : Any> RenderView<T>.asRenderer(): Renderer<T> {
    return Renderer(this, T::class.java)
}

typealias RenderCondition = (item: Any) -> Boolean