package com.prj.nolja.util

import androidx.lifecycle.Observer

// https://leveloper.tistory.com/200
// https://yk-coding-letter.tistory.com/6
// 공부하자 완벽하게 이해될때까지

open class Event<out T>(private val content : T) {
    var hasBeenHandled = false
        private set  // read가능 , write 불가능
    fun getContentIfNotHandled() : T? {
        return if(hasBeenHandled){
            null
        }else{
            hasBeenHandled = true
            content
        }
    }

    fun peekContent() : T = content

}
class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}
