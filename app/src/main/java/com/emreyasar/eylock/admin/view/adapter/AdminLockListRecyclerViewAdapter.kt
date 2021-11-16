package com.emreyasar.eylock.admin.view.adapter

import android.view.ViewGroup
import com.emreyasar.eylock.base.BaseRecyclerViewAdapter
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.dashboard.view.adapter.LockListRecyclerViewHolder

class AdminLockListRecyclerViewAdapter(val presenter: AdminContract.Presenter<AdminContract.View>) :
    BaseRecyclerViewAdapter<LockListRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockListRecyclerViewHolder {
        return LockListRecyclerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LockListRecyclerViewHolder, position: Int) {
        holder.binding.lockListItemName.text = "Lock Name for $position"
        holder.itemView.setOnClickListener {
            //presenter.onLockItemClicked()
        }
    }

    override fun getItemCount(): Int {
        return 45
    }
}