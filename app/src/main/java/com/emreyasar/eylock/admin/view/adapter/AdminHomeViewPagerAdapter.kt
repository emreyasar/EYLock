package com.emreyasar.eylock.admin.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.admin.view.fragment.AdminLockListFragment
import com.emreyasar.eylock.admin.view.fragment.AdminUserListFragment

class AdminHomeViewPagerAdapter(fm: FragmentManager, val presenter: AdminContract.Presenter<AdminContract.View>) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return presenter.getTabCount()
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                AdminUserListFragment(presenter)
            }
            1 -> {
                AdminLockListFragment(presenter)
            }
            else -> {
                AdminUserListFragment(presenter)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "User List"
            }
            1 -> {
                return "Lock List"
            }
        }
        return super.getPageTitle(position)
    }
}