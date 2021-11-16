package com.emreyasar.eylock.admin

import com.emreyasar.eylock.base.BasePresenter
import com.emreyasar.eylock.base.BaseView

interface AdminContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
        abstract fun getTabCount(): Int
    }

    abstract class NewUserPresenter<V: View> : BasePresenter<V>() {
        abstract fun addNewUser(name: String, email: String)
    }

    interface View : BaseView {
        fun newUserAdded(result: Boolean)
    }
}