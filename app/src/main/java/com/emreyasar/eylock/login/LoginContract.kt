package com.emreyasar.eylock.login

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface LoginContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
    }

    interface View : BaseView {

    }
}