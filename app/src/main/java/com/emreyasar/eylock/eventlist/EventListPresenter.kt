package com.emreyasar.eylock.eventlist

class EventListPresenter(view: EventListContract.View) : EventListContract.Presenter {

    private var view: EventListContract.View? = view

    override fun onViewCreated() {
        // do nothing
    }

    override fun onDestroy() {
        this.view = null
    }


}