package com.mcgars.delegate_example.core.delegat.adapter

import com.mcgars.basekitk.features.recycler2.AdapterDelegate
import com.mcgars.basekitk.features.recycler2.AdapterDelegateHeader

class Delegate<T : Any>(
    items: MutableList<T>,
    vararg val renders: AdapterDelegate<T>,
    advanced: ((AdapterDelegateHeader<T>)-> Unit)? = null
) : AdapterDelegateHeader<T>(items) {

    init {
        renders.forEach {
            addDelegate(it)
        }
        advanced?.invoke(this)
    }
}