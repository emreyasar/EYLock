package com.emreyasar.eylock.login.presenter

import com.emreyasar.eylock.database.repository.UserRepository
import com.emreyasar.eylock.login.LoginContract
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LoginPresenter<V: LoginContract.View> @Inject internal constructor(private val userRepository: UserRepository) : LoginContract.Presenter<V>(),
    CoroutineScope {

    private var job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun login(email: String, password: String) {
        launch {
            val user = userRepository.getUserByMail(email)
            withContext(Dispatchers.Main) {
                if (user != null && password.contentEquals("123456")) {
                    getView()?.loginCompleted(true, user.userId)
                } else {
                    getView()?.loginCompleted(false, null)
                }
            }
        }
    }

}