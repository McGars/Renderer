package com.mcgars.delegate_example.feature.example_1.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcgars.basekitk.features.recycler2.AbsListItemAdapterDelegate
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.basekitk.tools.gone
import com.mcgars.basekitk.tools.inflate
import com.mcgars.delegate_example.R
import kotlinx.android.synthetic.main.item_list_2.view.*
import kotlinx.android.synthetic.main.item_list_header.view.tvTitle
import com.mcgars.delegate_example.domain.model.Text


class TextAdapterDelegate(
    private val onItemClickListener: (Text) -> Unit
) : AbsListItemAdapterDelegate<Text, Any, RecyclerView.ViewHolder>() {

    /**
     * Check if this delegate can handle model
     */
    override fun isForViewType(item: Any, items: List<Any>, position: Int): Boolean {
        return item is Text
    }

    /**
     * Set model's data in view
     */
    override fun onBindViewHolder(item: Text, viewHolder: RecyclerView.ViewHolder) {
        with(viewHolder.itemView) {
            // only for presentation (findViewById here)
            tvTitle.text = item.name
            tvSubtitle.text = item.subname
            tvSubtitle.gone(item.subname.isNullOrEmpty())

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
        return object : RecyclerView.ViewHolder(parent.context.inflate(R.layout.item_list_2, parent)) {
            init {
                // little better for ClickListener
                itemView.setOnClickListener {
                    val item = kitAdapter.getItem(adapterPosition) as? Text ?: return@setOnClickListener
                    onItemClickListener.invoke(item)
                }
            }
        }
    }
}