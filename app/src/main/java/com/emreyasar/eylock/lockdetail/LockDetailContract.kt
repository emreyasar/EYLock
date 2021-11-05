package com.emreyasar.eylock.lockdetail

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface LockDetailContract {

    interface Presenter : BasePresenter {
        fun onViewCreated()
    }

    interface View : BaseView<Presenter> {

    }
}