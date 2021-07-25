package com.selen.english.ui.base

import androidx.fragment.app.Fragment
import com.selen.english.app.App
import com.selen.english.di.AppComponent

/**
 * @author Pyaterko Aleksey
 */
open class BaseFragment : Fragment() {

    val appComponent: AppComponent
        get() = (requireActivity().application as App).appComponent
}