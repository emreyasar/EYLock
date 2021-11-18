package com.emreyasar.eylock.dashboard

import com.emreyasar.eylock.base.BasePresenter
import com.emreyasar.eylock.base.BaseView
import com.emreyasar.eylock.database.entity.LockEntity

interface DashboardContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
        abstract fun onLockItemClicked()
        abstract fun getItemCount(): Int
        abstract fun getItemForPosition(position: Int): LockEntity
    }

    interface View : BaseView {
        fun onLockItemClicked()
        fun lockListFetched()
    }
}