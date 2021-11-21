package com.emreyasar.eylock.eventlist.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreyasar.eylock.R
import com.emreyasar.eylock.eventlist.EventListContract

class EventListRecyclerViewAdapter(val presenter: EventListContract.Presenter<EventListContract.View>) :
    RecyclerView.Adapter<EventListRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListRecyclerViewHolder {
        return EventListRecyclerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EventListRecyclerViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.binding.eventListEventType.text = "Entrance"
            holder.binding.eventListUserImg.setImageResource(R.drawable.ic_male_avatar)
        } else {
            holder.binding.eventListEventType.text = "Exit"
            holder.binding.eventListUserImg.setImageResource(R.drawable.ic_female_avatar)
        }
        holder.binding.eventListEventTime.text = "${(0..12).random().toString().padStart(2, '0')}:${(0..59).random().toString().padStart(2, '0')}"
        holder.binding.eventListUserName.text = "Lorem ipsum"

    }

    override fun getItemCount(): Int {
        return 15
    }
}