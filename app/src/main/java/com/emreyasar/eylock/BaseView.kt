package com.emreyasar.eylock

interface BaseView<T> {
    fun setPresenter(presenter: T)
}