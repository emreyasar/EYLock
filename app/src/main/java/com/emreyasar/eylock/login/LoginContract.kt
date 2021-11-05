package com.emreyasar.eylock.login

import com.emreyasar.eylock.BasePresenter
import com.emreyasar.eylock.BaseView

interface LoginContract {

    interface Presenter : BasePresenter {
        fun onViewCreated()
    }

    interface View : BaseView<Presenter> {

    }
}