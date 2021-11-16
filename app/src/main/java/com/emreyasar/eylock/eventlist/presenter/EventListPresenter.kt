package com.emreyasar.eylock.eventlist.presenter

import com.emreyasar.eylock.eventlist.EventListContract
import javax.inject.Inject

class EventListPresenter<V: EventListContract.View> @Inject internal constructor() : EventListContract.Presenter<V>() {


}