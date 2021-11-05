package com.emreyasar.eylock.login

class LoginPresenter(view: LoginContract.View) : LoginContract.Presenter {

    private var view: LoginContract.View? = view

    override fun onViewCreated() {
        // do nothing
    }

    override fun onDestroy() {
        this.view = null
    }


}