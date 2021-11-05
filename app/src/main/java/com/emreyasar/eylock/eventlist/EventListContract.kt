package com.emreyasar.eylock.eventlist

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface EventListContract {

    interface Presenter : BasePresenter {
        fun onViewCreated()
    }

    interface View : BaseView<Presenter> {

    }
}