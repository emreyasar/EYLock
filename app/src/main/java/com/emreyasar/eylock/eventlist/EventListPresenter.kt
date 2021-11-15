package com.emreyasar.eylock.eventlist

import javax.inject.Inject

class EventListPresenter<V: EventListContract.View> @Inject internal constructor() : EventListContract.Presenter<V>() {


}