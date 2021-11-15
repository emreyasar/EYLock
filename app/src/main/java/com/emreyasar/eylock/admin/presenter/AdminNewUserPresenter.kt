package com.emreyasar.eylock.admin.presenter

import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.database.repository.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AdminNewUserPresenter<V: AdminContract.View> @Inject internal constructor(private val userRepository: UserRepository) : AdminContract.NewUserPresenter<V>() {

    override fun addNewUser(name: String, email: String) {
        GlobalScope.launch {
            userRepository.insertUser(email, name)
        }
    }
}