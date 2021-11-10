package com.emreyasar.eylock.admin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdminHomeViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                AdminUserListFragment()
            }
            1 -> {
                AdminLockListFragment()
            }
            else -> {
                AdminUserListFragment()
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