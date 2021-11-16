package com.emreyasar.eylock

import android.content.Context
import androidx.room.Room
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.admin.presenter.AdminNewUserPresenter
import com.emreyasar.eylock.admin.presenter.AdminPresenter
import com.emreyasar.eylock.dashboard.DashboardContract
import com.emreyasar.eylock.dashboard.presenter.DashboardPresenter
import com.emreyasar.eylock.database.AppDatabase
import com.emreyasar.eylock.database.repository.UserRepository
import com.emreyasar.eylock.database.repository.UserRepositoryImpl
import com.emreyasar.eylock.eventlist.EventListContract
import com.emreyasar.eylock.eventlist.presenter.EventListPresenter
import com.emreyasar.eylock.lockdetail.LockDetailContract
import com.emreyasar.eylock.lockdetail.presenter.LockDetailPresenter
import com.emreyasar.eylock.login.LoginContract
import com.emreyasar.eylock.login.presenter.LoginPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "EYLOCK"
        ).build()
    }

    @Provides
    @Singleton
    internal fun provideUserRepositoryHelper(appDatabase: AppDatabase): UserRepository = UserRepositoryImpl(appDatabase.userDao())

    @Provides
    @Singleton
    internal fun provideAdminNewUserPresenter(presenter: AdminNewUserPresenter<AdminContract.View>): AdminContract.NewUserPresenter<AdminContract.View> = presenter

    @Provides
    @Singleton
    internal fun provideAdminPresenter(presenter: AdminPresenter<AdminContract.View>): AdminContract.Presenter<AdminContract.View> = presenter

    @Provides
    @Singleton
    internal fun provideDashboardPresenter(presenter: DashboardPresenter<DashboardContract.View>): DashboardContract.Presenter<DashboardContract.View> = presenter

    @Provides
    @Singleton
    internal fun provideEventListPresenter(presenter: EventListPresenter<EventListContract.View>): EventListContract.Presenter<EventListContract.View> = presenter

    @Provides
    @Singleton
    internal fun provideLockDetailPresenter(presenter: LockDetailPresenter<LockDetailContract.View>): LockDetailContract.Presenter<LockDetailContract.View> = presenter

    @Provides
    @Singleton
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginContract.View>): LoginContract.Presenter<LoginContract.View> = presenter

}