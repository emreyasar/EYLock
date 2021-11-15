package com.emreyasar.eylock.dashboard

import javax.inject.Inject

class DashboardPresenter<V: DashboardContract.View> @Inject internal constructor() : DashboardContract.Presenter<V>() {

    override fun onLockItemClicked() {
        getView()?.onLockItemClicked()
    }

}