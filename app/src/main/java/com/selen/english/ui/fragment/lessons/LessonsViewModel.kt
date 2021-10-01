package com.selen.english.ui.fragment.lessons

import com.selen.english.ui.base.BaseViewModel
import com.selen.english.ui.fragment.lessons.interactor.LessonsInteractor
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class LessonsViewModel @Inject constructor(private val lessonsInteractor: LessonsInteractor) :
    BaseViewModel() {

    override fun onStart() {}

}