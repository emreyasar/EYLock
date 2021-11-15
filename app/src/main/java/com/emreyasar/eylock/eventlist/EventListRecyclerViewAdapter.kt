package com.emreyasar.eylock.eventlist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EventListRecyclerViewAdapter(val presenter: EventListContract.Presenter<EventListContract.View>) :
    RecyclerView.Adapter<EventListRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListRecyclerViewHolder {
        return EventListRecyclerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EventListRecyclerViewHolder, position: Int) {
        //holder.binding.lockListItemName.text = "Lock Name for $position"
    }

    override fun getItemCount(): Int {
        return 45
    }
}