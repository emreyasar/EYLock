package com.emreyasar.eylock.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreyasar.eylock.databinding.ViewDashboardLockListItemBinding

class LockListRecyclerViewHolder(val binding: ViewDashboardLockListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): LockListRecyclerViewHolder {
            return LockListRecyclerViewHolder(
                ViewDashboardLockListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}