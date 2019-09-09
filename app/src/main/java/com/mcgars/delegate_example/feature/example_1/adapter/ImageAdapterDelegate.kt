package com.mcgars.delegate_example.feature.example_1.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcgars.basekitk.features.recycler2.AbsListItemAdapterDelegate
import com.mcgars.basekitk.features.recycler2.KitAdapter
import com.mcgars.basekitk.tools.inflate
import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.domain.model.Image
import kotlinx.android.synthetic.main.item_image.view.*


class ImageAdapterDelegate : AbsListItemAdapterDelegate<Image, Any, RecyclerView.ViewHolder>() {

    /**
     * Check if this delegate can handle model
     */
    override fun isForViewType(item: Any, items: List<Any>, position: Int): Boolean {
        return item is Image
    }

    /**
     * Set model's data in view
     */
    override fun onBindViewHolder(item: Image, viewHolder: RecyclerView.ViewHolder) {
        with(viewHolder.itemView) {
            // only for presentation (findViewById here)
            ivImage.setImageResource(item.value)
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
            parent.context.inflate(R.layout.item_image, parent)
        ) {}
    }
}