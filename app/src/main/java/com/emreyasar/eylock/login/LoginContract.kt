package com.emreyasar.eylock.login

import com.emreyasar.eylock.base.BasePresenter
import com.emreyasar.eylock.base.BaseView

interface LoginContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
    }

    interface View : BaseView {

    }
}