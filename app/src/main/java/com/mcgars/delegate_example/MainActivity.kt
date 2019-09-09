package com.mcgars.delegate_example

import android.os.Bundle
import com.mcgars.basekitk.features.base.BaseKitActivity
import com.mcgars.delegate_example.feature.main.MainViewController

class MainActivity : BaseKitActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            loadPage(MainViewController())
        }
    }
}
