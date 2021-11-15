package com.emreyasar.eylock

interface BaseMVPPresenter<V: BaseView> {

    fun onDestroy()

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}