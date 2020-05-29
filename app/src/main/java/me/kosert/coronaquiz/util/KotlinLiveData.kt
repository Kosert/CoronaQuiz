package me.kosert.coronaquiz.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

open class KotlinLiveData<T>(default: T) : MutableLiveData<T>() {

    init {
        this.value = default
    }

    override fun getValue() = super.getValue() as T

    open fun observe(owner: LifecycleOwner, observer: (t: T) -> Unit) {
        this.observe(owner, Observer {
            observer(it)
        })
    }


}