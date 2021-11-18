package com.emreyasar.eylock.dashboard.presenter

import com.emreyasar.eylock.EYLockContext
import com.emreyasar.eylock.dashboard.DashboardContract
import com.emreyasar.eylock.database.entity.LockEntity
import com.emreyasar.eylock.database.entity.UserWithLocks
import com.emreyasar.eylock.database.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DashboardPresenter<V: DashboardContract.View> @Inject internal constructor(private val userRepository: UserRepository) : DashboardContract.Presenter<V>(),
    CoroutineScope {

    private var job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    var lockList: List<LockEntity> = arrayListOf()

    override fun onViewCreated(view: V?) {
        super.onViewCreated(view)
        launch {
            if (EYLockContext.loginUserId != null) {
                lockList = userRepository.getUserWithLocks(EYLockContext.loginUserId!!).locks
                getView()?.lockListFetched()
            }
        }
    }

    override fun getItemCount(): Int {
        return lockList.size
    }

    override fun getItemForPosition(position: Int): LockEntity {
        return lockList[position]
    }

    override fun onLockItemClicked() {
        getView()?.onLockItemClicked()
    }

}