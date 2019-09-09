package com.mcgars.delegate_example.feature.example_2_render

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcgars.basekitk.features.base.BaseViewController
import com.mcgars.basekitk.tools.toast
import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.feature.example_2_render.render.RenderText
import com.mcgars.delegate_example.feature.example_2_render.render.RenderTitle
import com.mcgars.delegate_example.domain.repository.Repository
import com.mcgars.delegate_example.core.delegat.adapter.Delegate
import com.mcgars.delegate_example.core.delegat.adapter.Renderer
import com.mcgars.delegate_example.core.delegat.adapter.asRenderer
import com.mcgars.delegate_example.core.delegat.render.RenderLooperContainer
import com.mcgars.delegate_example.domain.model.Text
import com.mcgars.delegate_example.domain.model.Title
import com.mcgars.delegate_example.core.delegat.render.RenderClickable
import com.mcgars.delegate_example.feature.example_2_render.render.RenderImage


class PageRendererViewController : BaseViewController() {

    private val repository = Repository()

    private val recyclerView: RecyclerView? by lazy { view?.findViewById<RecyclerView>(R.id.recycleView) }

    /*
     * Delegate adapter with renderer
     */
    private val adapter = Delegate(
        items = mutableListOf(),
        renders = *arrayOf(
            // responsible for rendering title element
            Renderer.create(RenderTitle<Title>()),
            // Group
            RenderLooperContainer(
                // responsible for rendering text element
                RenderText(),
                // responsible for handle click
                RenderClickable { item, _ -> onItemSelected(item) }
            ).asRenderer(),
            // image
            RenderImage().asRenderer()
        )
    )

    override fun getLayoutId(): Int = R.layout.basekit_view_recycler

    override fun onReady(view: View) {
        adapter.addItems(repository.getItems())

        recyclerView?.layoutManager = LinearLayoutManager(requireNotNull(activity))
        recyclerView?.adapter = adapter
    }

    private fun onItemSelected(item: Text) {
        requireNotNull(activity).toast(item.name)
    }

}