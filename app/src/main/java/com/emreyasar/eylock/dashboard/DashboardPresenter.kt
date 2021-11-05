package com.emreyasar.eylock.dashboard

class DashboardPresenter(view: DashboardContract.View) : DashboardContract.Presenter {

    private var view: DashboardContract.View? = view

    override fun onViewCreated() {
        // do nothing
    }

    override fun onLockItemClicked() {
        this.view?.onLockItemClicked()
    }

    override fun onDestroy() {
        this.view = null
    }


}