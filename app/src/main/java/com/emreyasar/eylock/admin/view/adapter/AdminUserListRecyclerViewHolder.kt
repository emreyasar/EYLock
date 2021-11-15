package com.emreyasar.eylock.admin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreyasar.eylock.databinding.ViewAdminUserListItemBinding

class AdminUserListRecyclerViewHolder(val binding: ViewAdminUserListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): AdminUserListRecyclerViewHolder {
            return AdminUserListRecyclerViewHolder(
                ViewAdminUserListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}