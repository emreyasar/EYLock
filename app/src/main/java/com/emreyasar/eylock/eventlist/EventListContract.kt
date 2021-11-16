package com.emreyasar.eylock.eventlist

import com.emreyasar.eylock.base.BasePresenter
import com.emreyasar.eylock.base.BaseView

interface EventListContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
    }

    interface View : BaseView {

    }
}