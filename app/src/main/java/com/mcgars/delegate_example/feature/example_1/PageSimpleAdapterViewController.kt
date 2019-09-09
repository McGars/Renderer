package com.mcgars.delegate_example.feature.example_1

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcgars.basekitk.features.base.BaseViewController
import com.mcgars.basekitk.tools.toast
import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.domain.repository.Repository
import com.mcgars.delegate_example.feature.example_1.adapter.TextAdapterDelegate
import com.mcgars.delegate_example.feature.example_1.adapter.TitleAdapterDelegate
import com.mcgars.delegate_example.core.delegat.adapter.Delegate
import com.mcgars.delegate_example.feature.example_1.adapter.ImageAdapterDelegate


class PageSimpleAdapterViewController : BaseViewController() {

    private val repository = Repository()

    private val recyclerView: RecyclerView? by lazy { view?.findViewById<RecyclerView>(R.id.recycleView) }

    /*
     * Adapter delegate
     *
     * Separate logic between two components Title and Text
     */
    private val adapter = Delegate(
        items = mutableListOf(),
        renders = *arrayOf(
            TitleAdapterDelegate { onItemSelected(it) },
            TextAdapterDelegate { onItemSelected(it) },
            ImageAdapterDelegate()
        )
    )

    /**
     * UI xml
     */
    override fun getLayoutId(): Int = R.layout.basekit_view_recycler

    /**
     * ready to work with UI
     */
    override fun onReady(view: View) {
        adapter.addItems(repository.getItems())

        recyclerView?.layoutManager = LinearLayoutManager(requireNotNull(activity))
        recyclerView?.adapter = adapter
    }

    private fun onItemSelected(item: Any) {
        requireNotNull(activity).toast(item.toString())
    }

}