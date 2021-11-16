package com.emreyasar.eylock.dashboard.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreyasar.eylock.dashboard.DashboardContract

class LockListRecyclerViewAdapter(val presenter: DashboardContract.Presenter<DashboardContract.View>) :
    RecyclerView.Adapter<LockListRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockListRecyclerViewHolder {
        return LockListRecyclerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LockListRecyclerViewHolder, position: Int) {
        holder.binding.lockListItemName.text = "Lock Name for $position"
        holder.itemView.setOnClickListener {
            presenter.onLockItemClicked()
        }
    }

    override fun getItemCount(): Int {
        return 45
    }
}