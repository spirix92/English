package com.selen.english.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * @author Pyaterko Aleksey
 */
abstract class BaseViewModel : ViewModel() {

    private var viewModelJob = Job()
    open val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("CoroutineException", exception.message ?: "unknown exception")
    }

    private val viewModelScope = CoroutineScope(Dispatchers.IO + viewModelJob + exceptionHandler)

    private var isStarted: Boolean = false

    fun start() {
        if (!isStarted) {
            isStarted = true
            onStart()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    protected abstract fun onStart()

    fun <P> doWorkInMainThread(doOnAsyncBlock: suspend CoroutineScope.() -> P) {
        doCoroutineWork(doOnAsyncBlock, viewModelScope, Dispatchers.Main)
    }

    fun <P> doWork(doOnAsyncBlock: suspend CoroutineScope.() -> P) {
        doCoroutineWork(doOnAsyncBlock, viewModelScope, Dispatchers.IO)
    }

    private inline fun <P> doCoroutineWork(
        crossinline doOnAsyncBlock: suspend CoroutineScope.() -> P,
        coroutineScope: CoroutineScope,
        context: CoroutineContext
    ) {
        coroutineScope.launch {
            withContext(context) {
                doOnAsyncBlock.invoke(this)
            }
        }
    }

}