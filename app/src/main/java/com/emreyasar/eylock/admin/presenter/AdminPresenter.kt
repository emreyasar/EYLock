package com.emreyasar.eylock.admin.presenter

import com.emreyasar.eylock.admin.AdminContract
import javax.inject.Inject

class AdminPresenter<V: AdminContract.View> @Inject internal constructor() : AdminContract.Presenter<V>() {

    override fun getTabCount(): Int {
        return 2
    }
}