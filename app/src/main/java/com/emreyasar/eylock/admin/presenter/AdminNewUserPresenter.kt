package com.emreyasar.eylock.admin.presenter

import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.database.repository.UserRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AdminNewUserPresenter<V: AdminContract.View> @Inject internal constructor(private val userRepository: UserRepository) : AdminContract.NewUserPresenter<V>(), CoroutineScope {

    private var job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun addNewUser(name: String, email: String) {
        launch {
            val result = userRepository.insertUser(email, name)
            withContext(Dispatchers.Main) {
                getView()?.newUserAdded(result)
            }
        }
    }
}