package com.emreyasar.eylock.lockdetail

import com.emreyasar.eylock.base.BasePresenter
import com.emreyasar.eylock.base.BaseView

interface LockDetailContract {

    abstract class Presenter<V: View> : BasePresenter<V>() {
    }

    interface View : BaseView {

    }
}