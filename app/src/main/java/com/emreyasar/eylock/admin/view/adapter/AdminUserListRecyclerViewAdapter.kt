package com.emreyasar.eylock.admin.view.adapter

import android.view.ViewGroup
import com.emreyasar.eylock.base.BaseRecyclerViewAdapter
import com.emreyasar.eylock.admin.AdminContract

class AdminUserListRecyclerViewAdapter(val presenter: AdminContract.Presenter<AdminContract.View>) :
    BaseRecyclerViewAdapter<AdminUserListRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminUserListRecyclerViewHolder {
        return AdminUserListRecyclerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AdminUserListRecyclerViewHolder, position: Int) {
        holder.binding.adminUserListItemName.text = "User Name for $position"
        holder.itemView.setOnClickListener {
            //presenter.onLockItemClicked()
        }
    }

    override fun getItemCount(): Int {
        return 45
    }
}