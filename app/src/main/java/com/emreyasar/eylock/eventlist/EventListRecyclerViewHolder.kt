package com.emreyasar.eylock.eventlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreyasar.eylock.databinding.ViewEventsListItemBinding

class EventListRecyclerViewHolder(val binding: ViewEventsListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): EventListRecyclerViewHolder {
            return EventListRecyclerViewHolder(
                ViewEventsListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}