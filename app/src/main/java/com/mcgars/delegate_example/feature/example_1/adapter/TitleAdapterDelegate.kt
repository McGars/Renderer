package com.mcgars.delegate_example.feature.example_1.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcgars.basekitk.features.recycler2.AbsListItemAdapterDelegate
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.basekitk.tools.inflate
import com.mcgars.delegate_example.R
import kotlinx.android.synthetic.main.item_list_header.view.*
import com.mcgars.delegate_example.domain.model.Title


class TitleAdapterDelegate(
    private val onItemClickListener: (Title) -> Unit
) : AbsListItemAdapterDelegate<Title, Any, RecyclerView.ViewHolder>() {

    /**
     * Check if this delegate can handle model
     */
    override fun isForViewType(item: Any, items: List<Any>, position: Int): Boolean {
        return item is Title
    }

    /**
     * Set model's data in view
     */
    override fun onBindViewHolder(item: Title, viewHolder: RecyclerView.ViewHolder) {
        with(viewHolder.itemView) {
            // only for presentation (findViewById here)
            tvTitle.text = item.value

            // this is bad place for ClickListener
//            setOnClickListener { onItemClickListener.invoke(item) }
        }
    }

    /**
     * Create ViewHolder
     */
    override fun onCreateViewHolder(
        kitAdapter: KitAdapter<Any>,
        parent: ViewGroup
    ): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            parent.context.inflate(R.layout.item_list_header, parent)
        ) {
            init {
                // little better for ClickListener
                itemView.setOnClickListener {
                    val item = kitAdapter.getItem(adapterPosition) as? Title ?: return@setOnClickListener
                    onItemClickListener.invoke(item)
                }
            }
        }
    }
}