package com.emreyasar.eylock.eventlist

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface EventListContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
    }

    interface View : BaseView {

    }
}