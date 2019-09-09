package com.mcgars.delegate_example.feature.example_2_render.render

import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder
import kotlinx.android.synthetic.main.item_list_header.*
import com.mcgars.delegate_example.core.delegat.render.RenderViewInflate
import com.mcgars.delegate_example.domain.model.Image
import kotlinx.android.synthetic.main.item_image.*

class RenderImage : RenderViewInflate<Image>(R.layout.item_image) {
    override fun bindView(item: Image, vh: RenderViewHolder) = with(vh) {
        ivImage.setImageResource(item.value)
    }
}