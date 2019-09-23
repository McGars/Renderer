package com.mcgars.delegate_example.feature.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mcgars.basekitk.animatorHandlers.CircularRevealChangeHandler.Companion.RIGHT_CENTER
import com.mcgars.basekitk.animatorHandlers.CircularRevealChangeHandlerCompat
import com.mcgars.basekitk.features.base.BaseViewController
import com.mcgars.basekitk.features.recycler2.BaseRecycleViewDelegateController
import com.mcgars.delegate_example.feature.example_1.PageSimpleAdapterViewController
import com.mcgars.delegate_example.feature.example_2_render.PageRendererViewController
import com.mcgars.delegate_example.core.delegat.adapter.Delegate
import com.mcgars.delegate_example.core.delegat.adapter.asRenderer
import com.mcgars.delegate_example.core.delegat.render.RenderLooperContainer
import com.mcgars.delegate_example.core.delegat.render.RenderClickable
import com.mcgars.delegate_example.domain.model.Text
import com.mcgars.delegate_example.feature.example_2_render.render.RenderText
import java.lang.RuntimeException


class MainViewController : BaseRecycleViewDelegateController() {

    companion object {
        private const val DELEGATE_TITLE = "Example with delegates"
        private const val RENDER_TITLE = "Example with renders"
    }

    override fun onReady(view: View) {
        prepareData(listOf(
            Text(DELEGATE_TITLE),
            Text(RENDER_TITLE)
        ))
    }

    override fun getAdapter(list: MutableList<*>): RecyclerView.Adapter<*> {
        return Delegate(
            items = list as MutableList<Any>,
            renders = *arrayOf(
                // item container
                RenderLooperContainer(
                    RenderText(),
                    RenderClickable { item, _ -> onItemSelected(item) }
                ).asRenderer()
            )
        )
    }

    private fun onItemSelected(item: Text) {
        val page = when(item.name) {
            DELEGATE_TITLE -> PageSimpleAdapterViewController().animate()
            RENDER_TITLE -> PageRendererViewController().animate()
            else -> throw RuntimeException("$item not supported")
        }

        loadPage(page)
    }

    override fun loadData(page: Int) {

    }

    private fun BaseViewController.animate(): BaseViewController {
        overridePushHandler(CircularRevealChangeHandlerCompat().apply {
            halfPosition = RIGHT_CENTER
        })
        overridePopHandler(CircularRevealChangeHandlerCompat().apply {
            halfPosition = RIGHT_CENTER
        })
        return this
    }

}