package com.emreyasar.eylock.base

interface BaseMVPPresenter<V: BaseView> {

    fun onDestroy()

    fun onViewCreated(view: V?)

    fun getView(): V?

}