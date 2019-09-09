package com.mcgars.delegate_example.core.delegat.adapter

interface RenderCondition {
    fun isForViewType(item: Any): Boolean
}