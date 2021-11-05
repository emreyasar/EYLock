package com.emreyasar.eylock.lockdetail

class LockDetailPresenter(view: LockDetailContract.View) : LockDetailContract.Presenter {

    private var view: LockDetailContract.View? = view

    override fun onViewCreated() {
        // do nothing
    }

    override fun onDestroy() {
        this.view = null
    }


}