package com.emreyasar.eylock

abstract class BasePresenter<V: BaseView> : BaseMVPPresenter<V> {

    private var view: V? = null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        view = null
    }

    override fun onDestroy() {
        view = null
    }
    
}