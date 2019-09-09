package com.mcgars.delegate_example.domain.repository

import com.mcgars.delegate_example.R
import com.mcgars.delegate_example.domain.model.Image
import com.mcgars.delegate_example.domain.model.Text
import com.mcgars.delegate_example.domain.model.Title


class Repository {

    fun getItems(): List<Any> {
        return listOf(
            Title("Header 1"),
            Text("text 1", "subtitle 1"),
            Text("text 2", "subtitle 2"),
            Image(R.drawable.android),
            Title("Header 2"),
            Text("text 3", "subtitle 3"),
            Text("text 4", "subtitle 4"),
            Text("text 5", "subtitle 5")
        )
    }

}