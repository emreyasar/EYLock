package com.emreyasar.eylock.dashboard.view.adapter

import android.view.ViewGroup
import com.emreyasar.eylock.base.BaseRecyclerViewAdapter
import com.emreyasar.eylock.dashboard.DashboardContract

class LockListRecyclerViewAdapter(val presenter: DashboardContract.Presenter<DashboardContract.View>) :
    BaseRecyclerViewAdapter<LockListRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockListRecyclerViewHolder {
        return LockListRecyclerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LockListRecyclerViewHolder, position: Int) {
        val item = presenter.getItemForPosition(position)
        holder.binding.lockListItemName.text = item.name
        holder.itemView.setOnClickListener {
            presenter.onLockItemClicked()
        }
    }

    override fun getItemCount(): Int {
        return presenter.getItemCount()
    }
}