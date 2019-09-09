package com.mcgars.delegate_example.feature.example_2_render.render

import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder
import kotlinx.android.synthetic.main.item_list_header.*
import com.mcgars.delegate_example.core.delegat.render.RenderViewInflate

class RenderTitle<T> : RenderViewInflate<T>(R.layout.item_list_header) {
    override fun bindView(item: T, vh: RenderViewHolder) = with(vh) {
        tvTitle.text = item.toString()
    }
}