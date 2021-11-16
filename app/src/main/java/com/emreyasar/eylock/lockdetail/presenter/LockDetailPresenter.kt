package com.emreyasar.eylock.lockdetail.presenter

import com.emreyasar.eylock.lockdetail.LockDetailContract
import javax.inject.Inject

class LockDetailPresenter<V: LockDetailContract.View> @Inject internal constructor() : LockDetailContract.Presenter<V>() {


}