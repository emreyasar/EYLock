package com.emreyasar.eylock

interface BaseMVPPresenter<V: BaseView> {

    fun onDestroy()

    fun onViewCreated(view: V?)

    fun getView(): V?

}