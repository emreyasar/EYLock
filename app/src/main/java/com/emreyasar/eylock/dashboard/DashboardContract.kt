package com.emreyasar.eylock.dashboard

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface DashboardContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
        abstract fun onLockItemClicked()
    }

    interface View : BaseView {
        fun onLockItemClicked()
    }
}