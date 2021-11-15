package com.emreyasar.eylock

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<VH: RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    companion object {
        const val NO_DATA_VIEW_TYPE = 0
        const val DATA_LOADING = 1
        const val ITEM_VIEW_TYPE = 2
    }

    var dataStatus: DataStatus = DataStatus.LOADING
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        if (itemCount == 0 && dataStatus == DataStatus.READY) {
            return NO_DATA_VIEW_TYPE
        } else if (dataStatus == DataStatus.LOADING) {
            return DATA_LOADING
        }
        return ITEM_VIEW_TYPE
    }

}