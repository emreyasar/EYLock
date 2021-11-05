package com.emreyasar.eylock.dashboard

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface DashboardContract {

    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLockItemClicked()
    }

    interface View : BaseView<Presenter> {
        fun onLockItemClicked()
    }
}