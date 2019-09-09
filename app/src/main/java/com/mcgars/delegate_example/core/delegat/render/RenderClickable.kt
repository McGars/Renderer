package com.mcgars.delegate_example.core.delegat.render

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder

class RenderClickable<T> (
        private val click: (item: T, position: Int)->Unit
) : RenderView<T> {

    /*
    * Wrap origin view and decorate selectable
    */
    override fun getView(previousView: View?, parent: ViewGroup, inflater: LayoutInflater): View {
        return previousView ?: throw IllegalStateException("set this render after all others")
    }

    /*
    * Ignore
    */
    override fun bindView(item: T, vh: RenderViewHolder) = Unit

    /*
    * Bind click on created view
    */
    @Suppress("UNCHECKED_CAST")
    override fun attachClick(kitAdapter: KitAdapter<T>, vh: RenderViewHolder) = with(vh.itemView) {
        setOnClickListener {
            val item = kitAdapter.getItem(vh.adapterPosition) ?: return@setOnClickListener
            click.invoke(item, vh.adapterPosition)
        }
    }
}