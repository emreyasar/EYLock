package com.emreyasar.eylock.dashboard.presenter

import com.emreyasar.eylock.dashboard.DashboardContract
import javax.inject.Inject

class DashboardPresenter<V: DashboardContract.View> @Inject internal constructor() : DashboardContract.Presenter<V>() {

    override fun onLockItemClicked() {
        getView()?.onLockItemClicked()
    }

}