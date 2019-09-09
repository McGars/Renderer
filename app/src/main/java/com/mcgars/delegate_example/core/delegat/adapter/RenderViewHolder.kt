package com.mcgars.delegate_example.core.delegat.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer


open class RenderViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer