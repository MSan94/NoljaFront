package com.prj.nolja.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel(){

    private val compositedDisposable = CompositeDisposable()

    fun addDisposable(disposable : Disposable){
        compositedDisposable.add(disposable)
    }

    override fun onCleared() {
        compositedDisposable.clear()
        super.onCleared()
    }
}