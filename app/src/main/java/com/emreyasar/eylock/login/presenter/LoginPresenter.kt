package com.emreyasar.eylock.login.presenter

import com.emreyasar.eylock.login.LoginContract
import javax.inject.Inject

class LoginPresenter<V: LoginContract.View> @Inject internal constructor() : LoginContract.Presenter<V>() {

}