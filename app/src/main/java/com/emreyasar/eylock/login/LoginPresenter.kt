package com.emreyasar.eylock.login

import javax.inject.Inject

class LoginPresenter<V: LoginContract.View> @Inject internal constructor() : LoginContract.Presenter<V>() {

}