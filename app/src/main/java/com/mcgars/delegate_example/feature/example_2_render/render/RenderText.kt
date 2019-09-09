package com.mcgars.delegate_example.feature.example_2_render.render

import com.mcgars.basekitk.tools.gone
import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.core.delegat.adapter.RenderViewHolder
import kotlinx.android.synthetic.main.item_list_2.*
import com.mcgars.delegate_example.core.delegat.render.RenderViewInflate
import com.mcgars.delegate_example.domain.model.Text

open class RenderText : RenderViewInflate<Text>(R.layout.item_list_2) {

    override fun bindView(item: Text, vh: RenderViewHolder) = with(vh) {
        tvTitle.text = item.name
        tvSubtitle.text = item.subname
        tvSubtitle.gone(item.subname.isNullOrEmpty())
        Unit
    }

}